package br.com.acerta.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario_disciplina")
public class UsuarioDisciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;

    @Column(name = "respostas_certas", nullable = false)
    private Integer respostasCertas;

    // Constructors
    public UsuarioDisciplina() {}

    public UsuarioDisciplina(Usuarios usuario, Disciplina disciplina, Integer respostasCertas) {
        this.usuario = usuario;
        this.disciplina = disciplina;
        this.respostasCertas = respostasCertas;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Integer getRespostasCertas() {
        return respostasCertas;
    }

    public void setRespostasCertas(Integer respostasCertas) {
        this.respostasCertas = respostasCertas;
    }
}