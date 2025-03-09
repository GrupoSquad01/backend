package br.com.acerta.dto;

import java.util.ArrayList;
import java.util.List;

public class Pergunta {

	String enunciado;
	List<Resposta> respostas = new ArrayList<>();
	
	public Pergunta() {}

	public Pergunta(String enunciado, List<Resposta> respostas) {
		this.enunciado = enunciado;
		this.respostas = respostas;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	
}
