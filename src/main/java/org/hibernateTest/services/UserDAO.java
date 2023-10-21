package org.hibernateTest.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernateTest.datamodel.CustomUser;

public class UserDAO {

    private final SessionFactory sessionFactory = UserSessionFactory.getUserSessionFactory();

    public void saveUser(CustomUser u) {
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.merge(u);
        t.commit();
        s.close();
    }

    public CustomUser findUserByEmail(String email) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<CustomUser> userQuery = cb.createQuery(CustomUser.class);
        Root<CustomUser> root = userQuery.from(CustomUser.class);
        userQuery.select(root).where(cb.equal(root.get("email"), email));
        return session.createQuery(userQuery).getSingleResultOrNull();
    }
}
