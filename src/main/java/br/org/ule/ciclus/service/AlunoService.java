package br.org.ule.ciclus.service;

import br.org.ule.ciclus.dto.AlunoRequestDto;
import br.org.ule.ciclus.dto.AlunoResponseDto;
import br.org.ule.ciclus.entity.Aluno;
import br.org.ule.ciclus.entity.Monitor;
import br.org.ule.ciclus.entity.Turma;
import br.org.ule.ciclus.mapper.AlunoMapper;
import br.org.ule.ciclus.repository.AlunoRepository;
import br.org.ule.ciclus.repository.MonitorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;
    private final MonitorRepository monitorRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository, MonitorRepository monitorRepository){
        this.alunoRepository = alunoRepository;
        this.monitorRepository = monitorRepository;
    }

    // Criar alunos
    public AlunoResponseDto criarAluno (AlunoRequestDto dto) {
        Monitor monitor = monitorRepository.findById(dto.getMonitorId())
                .orElseThrow(() -> new EntityNotFoundException("Monitor não foi encontrado."));

        Aluno aluno = AlunoMapper.toEntity(dto, monitor);
        Aluno salvo = alunoRepository.save(aluno);

        return AlunoMapper.toDto(salvo);
    }

    // Listar Todos os Alunos
    public List<AlunoResponseDto> getAllAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream()
                .map(AlunoMapper::toDto)
                .collect(Collectors.toList());
    }

    //Procurar Alunos pelo Id
    public Optional<AlunoResponseDto> findById(Long id) {
        return alunoRepository.findById(id).map(AlunoMapper::toDto);
    }

    //Filtrar Alunos por turma
    public List<AlunoResponseDto> findByTurma(Turma turma) {
        List<Aluno> alunos = alunoRepository.findByTurma(turma);
        return alunos.stream()
                .map(AlunoMapper::toDto)
                .collect(Collectors.toList());
    }

    //Atualizar dados do Aluno
    public AlunoResponseDto update(Long id, @Valid AlunoRequestDto dto) {
        Aluno alunoSelecionado = alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        Monitor monitor = monitorRepository.findById(dto.getMonitorId())
                .orElseThrow(() -> new EntityNotFoundException("Monitor não encontrado"));

        alunoSelecionado.setNome(dto.getNome());
        alunoSelecionado.setTurma(dto.getTurma());
        alunoSelecionado.setMonitor(monitor);

        Aluno atualizado = alunoRepository.save(alunoSelecionado);

        return AlunoMapper.toDto(atualizado);
    }

    // Deletar um aluno
    public boolean delete(Long id) {
        Optional<Aluno> alunoSelecionado = alunoRepository.findById(id);
        if (alunoSelecionado.isPresent()) {
            alunoRepository.delete(alunoSelecionado.get());
            return true;
        } else {
            return false;
        }
    }

}
