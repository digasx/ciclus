package br.org.ule.ciclus.repository;

import br.org.ule.ciclus.entity.Aluno;
import br.org.ule.ciclus.entity.Monitor;
import br.org.ule.ciclus.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByTurma(Turma turma);
    //List<Monitor> findByMonitorId(Long monitorId);
}
