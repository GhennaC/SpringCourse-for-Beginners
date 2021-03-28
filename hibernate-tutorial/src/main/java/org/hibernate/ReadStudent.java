package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.entities.Student;


public class ReadStudent {

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
            Student student = new Student("Petuhovici","Wall","petuhovici@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the student obj
            session.save(student);
            System.out.println("Student saved...");

            // commit transaction
            session.getTransaction().commit();

            //find out the student's id: primary key
            System.out.println("student's id: "+student.getId());

            //get new session and start transaction
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // get the student with an primary key
            Student newStudent = session.get(Student.class, student.getId());
            System.out.println("student:" + newStudent);

            //commit
            session.getTransaction().commit();
            System.out.println("Done.");




        }finally {
            sessionFactory.close();
        }


    }


}
