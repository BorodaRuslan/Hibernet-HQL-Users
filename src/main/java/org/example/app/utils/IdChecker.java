package org.example.app.utils;

import org.example.app.entities.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class IdChecker {

    public static boolean IdExists(Users user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            user = session.get(Users.class, user.getId());

            if (user != null) {
                Query<Users> query = session.createQuery("From Users", Users.class);
                query.setMaxResults(1);
                query.getResultList();
            }
            return user != null;
        }
    }
}
