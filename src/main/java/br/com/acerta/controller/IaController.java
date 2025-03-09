package br.com.acerta.controller;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acerta.dto.DisciplinaDto;
import br.com.acerta.dto.Pergunta;
import br.com.acerta.service.DisciplinaService;

@RestController
@RequestMapping("/ia")
public class IaController {
	
	private final ChatClient chatClient;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	public IaController(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}

	@PostMapping("/test")
	public String testIa() {
		return chatClient.prompt().user("Envie-me uma curiosidade sobre computação, comece a resposta com \"Lá vai uma curiosidade sobre computação:\"").call().content();
	}
	
	@PostMapping("/gera-perguntas/{idDisciplina}")
	public List<Pergunta> geraPerguntas(@PathVariable Long idDisciplina) {
		DisciplinaDto disciplina = disciplinaService.buscarDisciplinaPorId(idDisciplina);
		return chatClient.prompt().user("Gere para mim 10 perguntas de " + disciplina.getNome() + ", nível ensino médio," + 
				" cada pergunta contendo 5 respostas (Usar classe Resposta), sendo apenas uma correta(Usar atributo respostaCerta para definir a correta)")
				.call().entity(new ParameterizedTypeReference<List<Pergunta>>() {});
	}
	
}
