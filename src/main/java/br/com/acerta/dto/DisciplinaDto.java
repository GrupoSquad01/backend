package br.com.acerta.dto;

public class DisciplinaDto {
	
	private Long id;
	
    private String nome;

    public DisciplinaDto() {}
    
    public DisciplinaDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
}
