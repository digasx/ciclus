package br.org.ule.ciclus.dto;

import jakarta.validation.constraints.NotBlank;

public class MonitorDto {
    private Long id;

    @NotBlank(message = "Informe o nome do monitor.")
    private String nome;

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
}
