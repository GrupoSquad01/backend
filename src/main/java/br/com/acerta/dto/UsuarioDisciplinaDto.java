package br.com.acerta.dto;

public class UsuarioDisciplinaDto {
	private Long id;
	private Long usuario;
	private Long disciplina;
	private Integer respostasCertas;

	public UsuarioDisciplinaDto() {}

	public UsuarioDisciplinaDto(Long usuariosDto, Long disciplinaDto, Integer respostasCertas) {
		this.usuario = usuariosDto;
		this.disciplina = disciplinaDto;
		this.respostasCertas = respostasCertas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUsuariosDto() {
		return usuario;
	}

	public void setUsuariosDto(Long usuariosDto) {
		this.usuario = usuariosDto;
	}

	public Long getDisciplinaDto() {
		return disciplina;
	}

	public void setDisciplinaDto(Long disciplinaDto) {
		this.disciplina = disciplinaDto;
	}

	public Integer getRespostasCertas() {
		return respostasCertas;
	}

	public void setRespostasCertas(Integer respostasCertas) {
		this.respostasCertas = respostasCertas;
	}

}