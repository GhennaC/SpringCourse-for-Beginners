package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.entities.Student;

import java.util.List;


public class QueryStudent {

    public static void displayStudents(List<Student> studentList) {
        studentList.forEach(System.out::println);
    }
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Student.class)
                                            .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();

        try{

            session.beginTransaction();

            List<Student> studentList = session.createQuery
                    ("from Student").list();

            displayStudents(studentList);
            System.out.println("\n\n");

            studentList = session.createQuery
                    ("from Student s where s.firstName='Petuhovici'" +
                            " or s.firstName='Petuhovicic'").getResultList();

            displayStudents(studentList);
            System.out.println("\n\n");

            studentList = session.createQuery
                    ("from Student s where s.email LIKE '%eb%'").getResultList();
            displayStudents(studentList);

            studentList.add(new Student("Paul","Jean","jean@mail.ru"));


            session.getTransaction().commit();
            System.out.println("Done.");
        }finally {
            sessionFactory.close();
        }


    }


}
