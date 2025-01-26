package br.com.acerta.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

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

    private String telefone;

    private String foto;

    private Timestamp dataNascimento;

    private String nacionalidade;

    private String raca;

    private String genero;

    private Integer sequenciaDias;

    private Timestamp dataUltimaResposta;

//    Constructors

    public Usuarios() {}

    public Usuarios(Long id, String nome, String username, String email, String senha, String telefone, String foto, Timestamp dataNascimento, String nacionalidade, String raca, String genero, int sequenciaDias, Timestamp dataUltimaResposta) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.foto = foto;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.raca = raca;
        this.genero = genero;
        this.sequenciaDias = sequenciaDias;
        this.dataUltimaResposta = dataUltimaResposta;
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

    public Timestamp getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Timestamp dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getSequenciaDias() {
        return sequenciaDias;
    }

    public void setSequenciaDias(int sequenciaDias) {
        this.sequenciaDias = sequenciaDias;
    }

    public Timestamp getDataUltimaResposta() {
        return dataUltimaResposta;
    }

    public void setDataUltimaResposta(Timestamp dataUltimaResposta) {
        this.dataUltimaResposta = dataUltimaResposta;
    }
}
