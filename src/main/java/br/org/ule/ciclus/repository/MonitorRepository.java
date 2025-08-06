package br.org.ule.ciclus.repository;

import br.org.ule.ciclus.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {
}
