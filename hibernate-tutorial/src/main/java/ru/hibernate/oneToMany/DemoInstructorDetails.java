package ru.hibernate.oneToMany;

import ru.hibernate.oneToMany.entities.Instructor;
import ru.hibernate.oneToMany.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DemoInstructorDetails {

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
            int id = 23;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class,id);
            System.out.println(instructorDetail);

            System.out.println("HOBANA\n\n"+instructorDetail.getInstructor());

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done.");

        }catch (Exception e){
          e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }


    }


}