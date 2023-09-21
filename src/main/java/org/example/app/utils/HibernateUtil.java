package org.example.app.utils;

import org.example.app.database.Credentials;
import org.example.app.entities.Users;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){

        if (sessionFactory == null){
            try {
                Configuration configuration = getConfiguration();
                configuration.addAnnotatedClass(Users.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return sessionFactory;
    }

    private static Configuration getConfiguration(){
        Configuration configuration = new Configuration();

        Properties setProperties = new Properties();

        setProperties.put(Environment.DRIVER, Contstans.DB_DRIVER);
        setProperties.put(Environment.URL, Contstans.BD_URL);
        setProperties.put(Environment.USER, Contstans.DB_USER);
        setProperties.put(Environment.PASS, Credentials.BD_PASS);
        setProperties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

        configuration.setProperties(setProperties);
        return configuration;

    }
}
