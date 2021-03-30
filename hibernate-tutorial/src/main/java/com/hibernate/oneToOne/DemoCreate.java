package com.hibernate.oneToOne;

import com.hibernate.oneToOne.entities.Instructor;
import com.hibernate.oneToOne.entities.InstructorDetail;
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
                                            .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();

        try{
            // create the objects
//            Instructor instructor = new Instructor
//                    ("Pisiun","Darby","darbypisiun@gmail.com");
//            InstructorDetail instructorDetail = new InstructorDetail
//                    ("http://www.pisiundarby.com/youtube","code");

            Instructor instructor = new Instructor
                    ("Pisiun","Darbovici","darbovicipisiun@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail
                    ("http://www.pisiundarbovici.com/youtube","nihuiane delati");

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
            sessionFactory.close();
        }


    }


}
