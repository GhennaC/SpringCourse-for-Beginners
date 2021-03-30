package md.eagerVsLazyDemo;

import md.eagerVsLazyDemo.entities.Course;
import md.eagerVsLazyDemo.entities.Instructor;
import md.eagerVsLazyDemo.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DemoInstructorLazyVsEager {

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

            // get instructor by primary key/id
            int id = 1;
            Instructor instructor = session.get(Instructor.class,id);
            System.out.println("AAAA"+instructor);

            System.out.println("HOBANA\n"+instructor.getCourseList());

            // commit transaction

            session.getTransaction().commit();

            session.close();
            System.out.println("HOBANA\n"+instructor.getCourseList());

            System.out.println("Done.");

        }catch (Exception e){
          e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }


    }


}
