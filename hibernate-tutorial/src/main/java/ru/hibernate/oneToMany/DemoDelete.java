package ru.hibernate.oneToMany;

import ru.hibernate.oneToMany.entities.Instructor;
import ru.hibernate.oneToMany.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DemoDelete {

    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate1.cfg.xml")
                                            .addAnnotatedClass(Instructor.class)
                                            .addAnnotatedClass(InstructorDetail.class)
                                            .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();

        try{


            // start a transaction
            session.beginTransaction();

            // get instructor by primary key/id
            int id = 1;
            Instructor instructor = session.get(Instructor.class,id);

            // delete the instructor
            if(instructor != null)
                session.delete(instructor);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done.");

        }finally {
            sessionFactory.close();
        }


    }


}
