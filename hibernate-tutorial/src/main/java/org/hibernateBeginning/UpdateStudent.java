package org.hibernateBeginning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernateBeginning.entities.Student;


public class UpdateStudent {

    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Student.class)
                                            .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();

        try{

            session  = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // get the student with an primary key
            Student newStudent = session.get(Student.class, 1);
            System.out.println("student:" + newStudent);

            newStudent.setFirstName("Scooby");

            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("delete from Student where id=2")
                    .executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done.");




        }finally {
            sessionFactory.close();
        }


    }


}
