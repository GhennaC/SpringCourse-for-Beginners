package ru.hibernate.oneToMany;

import ru.hibernate.oneToMany.entities.Course;
import ru.hibernate.oneToMany.entities.Instructor;
import ru.hibernate.oneToMany.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DemoCreate {

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

            // create obj
            Instructor instructor = new Instructor
                    ("Pisiun","Darbovici","darbovicipisiun@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail
                    ("http://www.pisiundarbovici.com/youtube","mmm..hueta");
            // Associate the obj
            instructor.setInstructorDetail(instructorDetail);

            // start a transaction
            session.beginTransaction();

            // save the obj
            // when we save instructor obj , cause we have cascade.ALL
            // the instructor detail will save too.
            session.save(instructor);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done.");

        }finally {

            session.close();

            sessionFactory.close();
        }


    }


}
