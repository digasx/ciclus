package br.org.ule.ciclus.repository;

import br.org.ule.ciclus.entity.Monitor;
import br.org.ule.ciclus.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {
    List<Monitor> findByTurma(Turma turma);
}
