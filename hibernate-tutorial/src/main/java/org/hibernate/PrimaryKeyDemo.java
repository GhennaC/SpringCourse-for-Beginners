package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.entities.Student;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();

        try{
            // create 3 student objects
            System.out.println("Creating 3 student objects...");
            Student student1 = new Student("Eblan","Wall","eblan@gmail.com");
            Student student2 = new Student("Eblun","Wall","eblun@gmail.com");
            Student student3 = new Student("Ebalan","Wall","ebalan@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the student obj
            session.save(student1);
            session.save(student2);
            session.save(student3);
            System.out.println("Students saved...");

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done.");

        }finally {
            sessionFactory.close();
        }


    }
}
