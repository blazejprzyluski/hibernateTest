package org.hibernateTest;

import org.hibernateTest.datamodel.CustomUser;
import org.hibernateTest.services.UserDAO;

public class Main {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        CustomUser u = new CustomUser();
        u.setEmail("test1@email.com");
        u.setName("Test");
        u.setLastName("Test");
        u.setAge(123);
        dao.saveUser(u);

        System.out.println(dao.findUserByEmail("test1@email.com"));
    }
}