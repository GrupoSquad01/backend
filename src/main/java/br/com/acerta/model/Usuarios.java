package br.com.acerta.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "foto")
    private String foto;

//    Constructors

    public Usuarios() {}

    public Usuarios(String nome, String username, String senha, String email, String telefone, String foto) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.foto = foto;
    }

//    Getters e setters

//    ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    Nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    Username
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

//    Senha
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

//    Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    Telefone
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

//    Foto
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
