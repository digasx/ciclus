package br.org.ule.ciclus.mapper;

import br.org.ule.ciclus.dto.MonitorRequestDto;
import br.org.ule.ciclus.dto.MonitorResponseDto;
import br.org.ule.ciclus.entity.Monitor;
import br.org.ule.ciclus.entity.Turma;

public class MonitorMapper {
    public static Monitor toEntity(MonitorRequestDto dto) {
        Monitor monitor = new Monitor();
        monitor.setNome(dto.getNome());
        monitor.setEmail(dto.getEmail());
        monitor.setTurma(Turma.deString(dto.getTurma()));
        return monitor;
    }

    public static MonitorResponseDto toDto(Monitor monitor) {
        return new MonitorResponseDto(
                monitor.getId(),
                monitor.getNome(),
                monitor.getEmail(),
                monitor.getTurma().name());
    }
}

