package org.example.Model;

import org.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

// Tudo relacionado ao CRUD (Create, Read, Update, Delete)

public class CursosDao { // DAO - Data Access Object (Objeto de Acesso a Dados)

    public void saveCurso(TabelaCursos curso) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(curso);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<TabelaCursos> getTabelaCursos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<TabelaCursos> createQuery = session.createQuery("from TabelaCursos", TabelaCursos.class);
            return createQuery.list();
        }
    }
}