package org.example.app.repositories;

import org.example.app.entities.Users;
import org.example.app.utils.Contstans;
import org.example.app.utils.HibernateUtil;
import org.example.app.utils.IdChecker;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class UsersDeleteRepositories {

    public String deleteUser(Users user) {

        if (IdChecker.IdExists(user)) {
            return deleteUserById(user);
        } else {
            return Contstans.ID_NO_EXISTS_MSG;
        }
    }

    public String deleteUserById(Users user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            user = session.get(Users.class, user.getId());

            if (user != null) {
                String hql = "DELETE FROM Users WHERE id = :id";
                MutationQuery query = session.createMutationQuery(hql);
                query.setParameter("id", user.getId());
                query.executeUpdate();
            }
            transaction.commit();
            return Contstans.DATA_UPDATE_MSG;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}
