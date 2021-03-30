package ru.hibernate.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.hibernate.oneToMany.entities.Course;
import ru.hibernate.oneToMany.entities.Instructor;
import ru.hibernate.oneToMany.entities.InstructorDetail;


public class DemoDeleteCourse {

    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Instructor.class)
                                            .addAnnotatedClass(InstructorDetail.class)
                                            .addAnnotatedClass(Course.class)
                                            .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();

        try{

            // start a transaction
            session.beginTransaction();

            // get a course
            int id = 10;
            Course course = session.get(Course.class,id);

            // delete a course
            session.delete(course);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done.");

        }finally {

            session.close();

            sessionFactory.close();
        }


    }


}
