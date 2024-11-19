package org.example.Model;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "tabela_inscricao")
public class TabelaInscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private TabelaAluno aluno;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private TabelaCursos curso;

    private String status;

    @Column(name = "alunoId")
    private String alunoId;

    @Column(name = "cursoId")
    private String cursoId;

    @Column(name = "dataInscricao")
    private LocalDate dataInscricao;

    public TabelaInscricao(int id, String alunoId, String cursoId, LocalDate dataInscricao) {
        this.id = id;
        this.alunoId = alunoId;
        this.cursoId = cursoId;
        this.dataInscricao = dataInscricao;
    }

    public TabelaInscricao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(String alunoId) {
        this.alunoId = alunoId;
    }

    public String getCursoId() {
        return cursoId;
    }

    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }

    public LocalDate getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(LocalDate dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Inscrição: " +
                "ID=" + id +
                ", alunoId='" + alunoId + '\'' +
                ", cursoId='" + cursoId + '\'' +
                ", Data Inscrição=" + dataInscricao.format(formatter);
    }
}