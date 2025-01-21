package br.com.acerta.dto;

public class UsuarioDisciplinaDto {
    private Long usuarioId;
    private Long disciplinaId;
    private Integer respostasCertas;

    public UsuarioDisciplinaDto(Long usuarioId, Long disciplinaId, Integer respostasCertas) {
        this.usuarioId = usuarioId;
        this.disciplinaId = disciplinaId;
        this.respostasCertas = respostasCertas;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Long disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public Integer getRespostasCertas() {
        return respostasCertas;
    }

    public void setRespostasCertas(Integer respostasCertas) {
        this.respostasCertas = respostasCertas;
    }
}
