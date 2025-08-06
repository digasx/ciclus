package br.org.ule.ciclus.controller;

import br.org.ule.ciclus.entity.Aluno;
import br.org.ule.ciclus.entity.Monitor;
import br.org.ule.ciclus.repository.AlunoRepository;
import br.org.ule.ciclus.repository.MonitorRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private AlunoRepository alunoRepository;
    private MonitorRepository monitorRepository;

    @GetMapping
    public List<Aluno> getAllAluno(){
        return alunoRepository.findAll();
    }



}
