package br.com.acerta.dto;

public class UsuarioDisciplinaDto {
	private Long id;
    private UsuariosDto usuariosDto;
    private DisciplinaDto disciplinaDto;
    private Integer respostasCertas;

    public UsuarioDisciplinaDto() {}
    
    public UsuarioDisciplinaDto(UsuariosDto usuariosDto, DisciplinaDto disciplinaDto, Integer respostasCertas) {
        this.usuariosDto = usuariosDto;
        this.disciplinaDto = disciplinaDto;
        this.respostasCertas = respostasCertas;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuariosDto getUsuariosDto() {
		return usuariosDto;
	}

	public void setUsuariosDto(UsuariosDto usuariosDto) {
		this.usuariosDto = usuariosDto;
	}

	public DisciplinaDto getDisciplinaDto() {
		return disciplinaDto;
	}

	public void setDisciplinaDto(DisciplinaDto disciplinaDto) {
		this.disciplinaDto = disciplinaDto;
	}

	public Integer getRespostasCertas() {
		return respostasCertas;
	}

	public void setRespostasCertas(Integer respostasCertas) {
		this.respostasCertas = respostasCertas;
	}
    
}
