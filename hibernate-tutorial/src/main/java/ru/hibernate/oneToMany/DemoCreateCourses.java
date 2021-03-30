package ru.hibernate.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.hibernate.oneToMany.entities.Course;
import ru.hibernate.oneToMany.entities.Instructor;
import ru.hibernate.oneToMany.entities.InstructorDetail;


public class DemoCreateCourses {

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

            // create some courses
            Course course1 = new Course("Guitar");
            Course course2 = new Course("Shooting");
            Course course3 = new Course("Swimming");

            // add courses to instructor
            instructor.addCourse(course1);
            instructor.addCourse(course2);
            instructor.addCourse(course3);

            //save courses
            session.save(course1);
            session.save(course2);
            session.save(course3);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done.");

        }finally {

            session.close();

            sessionFactory.close();
        }


    }


}
