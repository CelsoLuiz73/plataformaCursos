package org.example.Model;

import org.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

// Tudo relacionado ao CRUD (Create, Read, Update, Delete)

public class AlunoDao { // DAO - Data Access Object (Objeto de Acesso a Dados)

    public void saveAluno(TabelaAluno aluno) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(aluno);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<TabelaAluno> getTabelaAluno() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<TabelaAluno> createQuery = session.createQuery("from TabelaAluno", TabelaAluno.class);
            return createQuery.list();
        }
    }

    public void updateTabelaAluno(TabelaAluno aluno) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(aluno);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteTabelaAluno(int alunoId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            TabelaAluno aluno = session.get(TabelaAluno.class, alunoId);
            if (aluno != null) {
                session.remove(aluno);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
}
