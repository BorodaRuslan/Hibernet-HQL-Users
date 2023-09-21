package org.example.app.repositories;

import org.example.app.entities.Users;
import org.example.app.utils.Contstans;
import org.example.app.utils.HibernateUtil;
import org.example.app.utils.IdChecker;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class UsersUpdateRepository {

    public String updateUsers(Users users) {
        if (IdChecker.IdExists(users)) {
            return updateUserById(users);
        } else {
            return Contstans.ID_NO_EXISTS_MSG;
        }
    }
    private String updateUserById(Users user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.getTransaction();
            String hql = "UPDATE Users SET email = :email WHERE id = :id";

            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("email", user.getEmail());
            query.setParameter("id", user.getId());
            query.executeUpdate();

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
