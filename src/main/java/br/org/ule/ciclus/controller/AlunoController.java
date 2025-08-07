package br.org.ule.ciclus.controller;

import br.org.ule.ciclus.dto.AlunoRequestDto;
import br.org.ule.ciclus.dto.AlunoResponseDto;
import br.org.ule.ciclus.entity.Turma;
import br.org.ule.ciclus.service.AlunoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @Autowired
    public AlunoController (AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    //Criar aluno
    @PostMapping
    public ResponseEntity<AlunoResponseDto> criarAluno(@RequestBody @Valid AlunoRequestDto dto){
        AlunoResponseDto response = alunoService.criarAluno(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //Buscar todos os Alunos
    @GetMapping
    public List<AlunoResponseDto> getAllAlunos(){
        return alunoService.getAllAlunos();
    }

    // GET Aluno pelo id
    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> getAlunoById(@PathVariable Long id) {
        return alunoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //GET aluno pela turma
    @GetMapping("/turma")
    public ResponseEntity<List<AlunoResponseDto>> findByTurma(@RequestParam Turma turma) {
        List<AlunoResponseDto> alunos = alunoService.findByTurma(turma);

        if (alunos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(alunos);
    }

    // PUT para atualizar aluno
    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> update(@PathVariable Long id, @RequestBody @Valid AlunoRequestDto dto) {
        try {
            AlunoResponseDto atualizado = alunoService.update(id, dto);
            return ResponseEntity.ok(atualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE para excluir um aluno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean excluido = alunoService.delete(id);
        return excluido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
