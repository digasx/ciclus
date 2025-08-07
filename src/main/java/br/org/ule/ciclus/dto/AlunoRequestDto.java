package br.org.ule.ciclus.dto;

import br.org.ule.ciclus.entity.Turma;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AlunoRequestDto {

    @NotBlank(message = "O nome precisa ser informado.")
    private String nome;

    @NotNull(message = "A turma precisa ser informada.")
    private Turma turma;

    @NotNull(message = "O Id do monitor associado precisa ser informado.")
    private Long monitorId;

    // Construtor
    public AlunoRequestDto(){

    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Long getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(Long monitorId) {
        this.monitorId = monitorId;
    }
}
