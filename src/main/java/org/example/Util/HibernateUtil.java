package org.example.Util;

import org.example.Model.TabelaAluno;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    // Singleton: Criar um sessão:(Instância do Hibernate) Garante uma única instância do SessionFactory
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Configurações de propriedades do Hibernate
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/tabela_aluno?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "Senai1610#");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread"); // Para cada thread que estou rodando, eu vou ter um contexto diferente
                settings.put(Environment.HBM2DDL_AUTO, "create-drop"); // Ações que serão executadas automaticamente(Opções): update, validate, create, create-drop

                configuration.setProperties(settings);

                // Adiciona a classe anotada (entidade)
                configuration.addAnnotatedClass(TabelaAluno.class);

                // Registro do serviço
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                // Cria o SessionFactory
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}