package ro.OneToManyUnidirect;

import ro.OneToManyUnidirect.entities.Course;
import ro.OneToManyUnidirect.entities.Instructor;
import ro.OneToManyUnidirect.entities.InstructorDetail;
import ro.OneToManyUnidirect.entities.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DemoCreateCourseAndReviews {

    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(InstructorDetail.class)
                                            .addAnnotatedClass(Instructor.class)
                                            .addAnnotatedClass(Course.class)
                                            .addAnnotatedClass(Review.class)
                                            .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();

        try{


            // start a transaction
            session.beginTransaction();

            // create a course
            Course course = new Course("Kino");

            // create reviews
            // add reviews to course
            course.add(new Review("Pizdos"));
            course.add(new Review("Classno"));
            course.add(new Review("Pizdotenno"));
            course.add(new Review("Like it"));

            // save the course
            session.save(course);

            System.out.println(course);
            System.out.println(course.getReviewList());

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
