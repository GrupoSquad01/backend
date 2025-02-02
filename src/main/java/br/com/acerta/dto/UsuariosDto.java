package br.com.acerta.dto;

import java.sql.Timestamp;

public class UsuariosDto {
	private Long id;
	
    private String nome;

    private String username;

    private String senha;

    private String email;

    private String telefone;

    private String foto;

	private Timestamp dataNascimento;

	private String nacionalidade;

	private String raca;

	private String genero;

	private Integer sequenciaDias = 0;

	private Timestamp dataUltimaResposta;

    public UsuariosDto() {}
    
    public UsuariosDto(String nome, String username, String senha, String email, String telefone, String foto, Timestamp dataNascimento, String nacionalidade, String raca, String genero, Integer sequenciaDias, Timestamp dataUltimaResposta) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.foto = foto;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.raca = raca;
		this.sequenciaDias = sequenciaDias;
		this.dataUltimaResposta = dataUltimaResposta;
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

	public Timestamp getDataUltimaResposta() {
		return dataUltimaResposta;
	}

	public void setDataUltimaResposta(Timestamp dataUltimaResposta) {
		this.dataUltimaResposta = dataUltimaResposta;
	}

	public Integer getSequenciaDias() {
		return sequenciaDias;
	}

	public void setSequenciaDias(Integer sequenciaDias) {
		this.sequenciaDias = sequenciaDias;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Timestamp getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Timestamp dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
