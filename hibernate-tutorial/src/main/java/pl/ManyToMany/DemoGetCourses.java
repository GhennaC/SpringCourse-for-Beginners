package pl.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.ManyToMany.entities.*;


public class DemoGetCourses {

    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(InstructorDetail.class)
                                            .addAnnotatedClass(Instructor.class)
                                            .addAnnotatedClass(Course.class)
                                            .addAnnotatedClass(Review.class)
                                            .addAnnotatedClass(Student.class)
                                            .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();

        try{


            // start a transaction
            session.beginTransaction();

            // get the student from database
            int id = 2;
            Student student = session.get(Student.class,id);

            System.out.println("Student that you need: "+student);
            System.out.println();
            System.out.println("Student courses: " + student.getCourseList());
            System.out.println();

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
