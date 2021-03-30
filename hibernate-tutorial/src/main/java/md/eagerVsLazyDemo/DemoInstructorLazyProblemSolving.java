package md.eagerVsLazyDemo;

import md.eagerVsLazyDemo.entities.Course;
import md.eagerVsLazyDemo.entities.Instructor;
import md.eagerVsLazyDemo.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class DemoInstructorLazyProblemSolving {

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
            Query<Instructor> query =
                    session.createQuery("select i from Instructor i "+
                            "JOIN FETCH i.courseList "
                            + "where i.id=:theInstructorId",
                            Instructor.class);
            query.setParameter("theInstructorId",id);

            Instructor instructor= query.getSingleResult();

            System.out.println("Instructor: "+instructor);


            // commit transaction
            session.getTransaction().commit();

            session.close();
            System.out.println("COURSES:\n"+instructor.getCourseList());

            System.out.println("Done.");

        }catch (Exception e){
          e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }


    }


}
