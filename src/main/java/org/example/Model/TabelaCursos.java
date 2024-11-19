package org.example.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "tabela_cursos")
public class TabelaCursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private Set<TabelaInscricao> inscricoes;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "dataCriacao")
    private LocalDate dataCriacao;

    public TabelaCursos(int id, String nome, String descricao, LocalDate dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
    }

    public TabelaCursos() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Curso: " +
                "ID=" + id +
                ", Nome='" + nome + '\'' +
                ", Descrição='" + descricao + '\'' +
                ", Data de Criação=" + dataCriacao.format(formatter);
    }
}