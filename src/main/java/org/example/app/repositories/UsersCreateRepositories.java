package org.example.app.repositories;

import org.example.app.entities.Users;
import org.example.app.utils.Contstans;
import org.example.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class UsersCreateRepositories {
    public String createUser(Users user){

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            transaction = session.beginTransaction();

            String hql = "INSERT INTO Users (userName, firstName, lastName, email) " +
                    "VALUES (:userName, :firstName, :lastName, :email)";

            MutationQuery query = session.createMutationQuery(hql);

            query.setParameter("userName", user.getUserName());
            query.setParameter("firstName", user.getFirstName());
            query.setParameter("lastName", user.getLastName());
            query.setParameter(" email", user.getEmail());

            transaction.commit();
            return Contstans.DATA_INSERT_MSG;
        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}
