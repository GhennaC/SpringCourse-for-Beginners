package org.hibernateBeginning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernateBeginning.entities.Student;


public class CreateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Student.class)
                                            .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();

        try{
            // create a student object
            System.out.println("Creating a new student object...");
            Student student = new Student("Petuh","Wall","petuh@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the student obj
            session.save(student);
            System.out.println("Student saved...");

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done.");

        }finally {
            sessionFactory.close();
        }


    }


}
