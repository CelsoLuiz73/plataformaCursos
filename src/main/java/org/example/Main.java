package org.example;

import org.example.Model.AlunoDao;
import org.example.Model.TabelaAluno;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AlunoDao alunoDao = new AlunoDao();
        TabelaAluno aluno = new TabelaAluno(005, "Maria João", "maria@gmail.com", LocalDate.now());
        alunoDao.saveAluno(aluno);

        //List<TabelaAluno> alunos = alunoDao.getTabelaAluno();
        for (TabelaAluno t: alunoDao.getTabelaAluno()) {
            System.out.println(t.getNome());
        }

        aluno.setNome("Pedrão");
        alunoDao.updateTabelaAluno(aluno);

        for (TabelaAluno t: alunoDao.getTabelaAluno()) {
            System.out.println(t.getNome());
        }

        alunoDao.deleteTabelaAluno((int) aluno.getId());
    }
}