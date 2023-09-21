package org.example.app.repositories;

import org.example.app.entities.Users;
import org.example.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Collections;
import java.util.List;

public class UsersReadRepositories {

    public List<Users> readUsers() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Users> users = session.createQuery("From Users", Users.class).list();

            transaction.commit();
            return users;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
