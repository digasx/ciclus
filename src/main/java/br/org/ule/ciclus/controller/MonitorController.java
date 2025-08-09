package br.org.ule.ciclus.controller;


import br.org.ule.ciclus.dto.MonitorRequestDto;
import br.org.ule.ciclus.dto.MonitorResponseDto;
import br.org.ule.ciclus.entity.Turma;
import br.org.ule.ciclus.service.MonitorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitores")
public class MonitorController {

    private final MonitorService monitorService;

    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    //POST - criar monitor
    @PostMapping
    public ResponseEntity<MonitorResponseDto> criarMonitor(@Valid @RequestBody MonitorRequestDto dto) {
        MonitorResponseDto criado = monitorService.criarMonitor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    //GET todos os monitores
    @GetMapping
    public List<MonitorResponseDto> getAllMonitors() {
        return monitorService.getAllMonitors();
    }

    //GET monitor pelo id
    @GetMapping("/{id}")
    public ResponseEntity<MonitorResponseDto> getMonitorById(@PathVariable Long id) {
        return monitorService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Filtrar monitores por turma
    @GetMapping("/turma")
    public ResponseEntity<List<MonitorResponseDto>> getByTurma(@RequestParam Turma turma) {
        List<MonitorResponseDto> monitores = monitorService.getByTurma(turma);
        if (monitores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(monitores);
    }

    //PUT - atualizar monitor
    @PutMapping
    public ResponseEntity<MonitorResponseDto> updateMonitor(@PathVariable Long id, @Valid @RequestBody MonitorRequestDto dto) {
        MonitorResponseDto atualizado = monitorService.updateMonitor(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    // Deletar Monitor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMonitor(@PathVariable Long id) {
        monitorService.deleteMonitor(id);
        return ResponseEntity.noContent().build();
    }

}
