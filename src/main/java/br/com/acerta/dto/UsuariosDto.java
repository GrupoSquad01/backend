package br.com.acerta.dto;


public class UsuariosDto {
	
	private Long id;
	
    private String nome;

    private String username;

    private String senha;

    private String email;

    private String telefone;

    private String foto;

    public UsuariosDto() {}
    
    public UsuariosDto(String nome, String username, String senha, String email, String telefone, String foto) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.foto = foto;
    }

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
    
}
