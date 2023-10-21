package org.hibernateTest.services;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserSessionFactory {
    public static SessionFactory getUserSessionFactory() {
        Configuration config = new Configuration();
        config.configure("/hibernate.cfg.xml");
        return config.buildSessionFactory();
    }
}
