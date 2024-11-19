package org.example.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "tabela_aluno")
public class TabelaAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private Set<TabelaInscricao> inscricoes;

    @Column(name = "email")
    private String email;

    @Column(name = "dataCadastro")
    private LocalDate dataCadastro;


    public TabelaAluno(int id, String nome, String email, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    public TabelaAluno() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Aluno: " +
                "ID=" + id +
                ", Nome='" + nome + '\'' +
                ", E-mail='" + email + '\'' +
                ", Data de Cadastro=" + dataCadastro.format(formatter);
    }
}