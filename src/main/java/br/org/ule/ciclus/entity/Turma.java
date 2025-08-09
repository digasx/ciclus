package br.org.ule.ciclus.entity;

public enum Turma {
    A,
    B,
    C;

    //Converte string para enum e captura erro se enum não bater
    public static Turma deString(String valor) {
        try {
            return Turma.valueOf(valor.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Turma inválida: " + valor);
        }
    }
}
