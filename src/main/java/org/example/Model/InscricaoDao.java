package org.example.Model;

import org.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

// Tudo relacionado ao CRUD (Create, Read, Update, Delete)

public class InscricaoDao { // DAO - Data Access Object (Objeto de Acesso a Dados)

    public void saveInscricao(TabelaInscricao inscricao) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(inscricao);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<TabelaInscricao> getTabelaInscricao() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<TabelaInscricao> createQuery = session.createQuery("from TabelaCursos", TabelaInscricao.class);
            return createQuery.list();
        }
    }
}