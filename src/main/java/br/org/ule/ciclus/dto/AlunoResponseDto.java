package br.org.ule.ciclus.dto;

import br.org.ule.ciclus.entity.Turma;

public class AlunoResponseDto {
    private Long id;
    private String nome;
    private Turma turma;
    private Long monitorId;
    private String monitorNome;

    public AlunoResponseDto(){

    }
    // Construtor
    public AlunoResponseDto(Long id, String nome, Turma turma, Long monitorId, String monitorNome){
        this.id = id;
        this.nome = nome;
        this.turma = turma;
        this.monitorId = monitorId;
        this.monitorNome = monitorNome;
    }

    // Getter e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getMonitorNome() {
        return monitorNome;
    }

    public void setMonitorNome(String monitorNome) {
        this.monitorNome = monitorNome;
    }
}
