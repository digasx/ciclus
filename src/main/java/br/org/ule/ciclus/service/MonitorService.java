package br.org.ule.ciclus.service;

import br.org.ule.ciclus.dto.AlunoResponseDto;
import br.org.ule.ciclus.dto.MonitorRequestDto;
import br.org.ule.ciclus.dto.MonitorResponseDto;
import br.org.ule.ciclus.entity.Aluno;
import br.org.ule.ciclus.entity.Monitor;
import br.org.ule.ciclus.entity.Turma;
import br.org.ule.ciclus.error.ResourceNotFoundException;
import br.org.ule.ciclus.mapper.AlunoMapper;
import br.org.ule.ciclus.mapper.MonitorMapper;
import br.org.ule.ciclus.repository.MonitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MonitorService {

    private final MonitorRepository monitorRepository;

    public MonitorService(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    //Criar monitor
    public MonitorResponseDto criarMonitor(MonitorRequestDto dto) {
        Monitor monitor = MonitorMapper.toEntity(dto);
        Monitor salvo = monitorRepository.save(monitor);
        return MonitorMapper.toDto(salvo);
    }

    //Atualizar dados do monitor
    public MonitorResponseDto updateMonitor(Long id, MonitorRequestDto dto) {
        Monitor monitor = monitorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Monitor não encontrado"));

        monitor.setNome(dto.getNome());
        monitor.setEmail(dto.getEmail());
        monitor.setTurma(Turma.deString(dto.getTurma()));

        Monitor salvo = monitorRepository.save(monitor);
        return MonitorMapper.toDto(salvo);
    }

    //Listar os monitores
    public List<MonitorResponseDto> getAllMonitors() {
        return monitorRepository.findAll()
                .stream()
                .map(MonitorMapper::toDto)
                .collect(Collectors.toList());
    }

    //Listar monitor pelo id
    /*public MonitorResponseDto getMonitorById(Long id) {
        Monitor monitor = monitorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Monitor não encontrado"));
        return MonitorMapper.toDto(monitor);
    }*/

    //Listar monitor pelo id
    public Optional<MonitorResponseDto> getById(Long id) {
        return monitorRepository.findById(id).map(MonitorMapper::toDto);
    }

    //Filtrar monitor por turma
    public List<MonitorResponseDto> getByTurma(Turma turma) {
        List<Monitor> monitores = monitorRepository.findByTurma(turma);
        return monitores.stream()
                .map((MonitorMapper::toDto))
                .collect(Collectors.toList());
    }

    //Deletar monitor
    public void deleteMonitor(Long id) {
        Monitor monitor = monitorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Monitor não encontrado"));

        monitorRepository.delete(monitor);
    }


}
