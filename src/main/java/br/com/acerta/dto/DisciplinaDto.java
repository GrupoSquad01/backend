package br.com.acerta.dto;

public class DisciplinaDto {
    private String nome;

    public DisciplinaDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
