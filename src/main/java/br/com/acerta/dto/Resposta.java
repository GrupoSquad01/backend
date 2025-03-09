package br.com.acerta.dto;

public class Resposta {

	String texto;
	Boolean respostaCerta;
	
	public Resposta() {}

	public Resposta(String texto, Boolean respostaCerta) {
		this.texto = texto;
		this.respostaCerta = respostaCerta;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Boolean getRespostaCerta() {
		return respostaCerta;
	}

	public void setRespostaCerta(Boolean respostaCerta) {
		this.respostaCerta = respostaCerta;
	}
	
}
