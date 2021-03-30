package ru.hibernate.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.hibernate.oneToMany.entities.Course;
import ru.hibernate.oneToMany.entities.Instructor;
import ru.hibernate.oneToMany.entities.InstructorDetail;


public class DemoGetCourses {

    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate1.cfg.xml")
                                            .addAnnotatedClass(Instructor.class)
                                            .addAnnotatedClass(InstructorDetail.class)
                                            .addAnnotatedClass(Course.class)
                                            .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();

        try{

            // start a transaction
            session.beginTransaction();

            // get the instructor from db
            int id = 1;
            Instructor instructor = session.get(Instructor.class,id);

            System.out.println(instructor.getCourseList());
            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done.");

        }finally {

            session.close();

            sessionFactory.close();
        }


    }


}
