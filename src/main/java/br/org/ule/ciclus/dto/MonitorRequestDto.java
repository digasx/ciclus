package br.org.ule.ciclus.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class MonitorRequestDto {
    @NotBlank(message = "O nome precisa ser informado.")
    private String nome;

    @Email(message = "O email precisa ser informado.")
    private String email;

    @NotBlank(message = "A turma precisa ser informada.")
    private String turma;



    //Getter e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
