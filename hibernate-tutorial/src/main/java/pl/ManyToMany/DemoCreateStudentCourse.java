package pl.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.ManyToMany.entities.*;



public class DemoCreateStudentCourse {

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

            // create a course
            Course course = new Course("Kino");

            // save the course
            session.save(course);
            System.out.println("Saved the course: " + course);

            // create students
            Student student1 = new Student("John","Doe","john@gmail.com");
            Student student2 = new Student("Johny","LittleBoy","johny@gmail.com");

            // add students to the course list
            course.addStudent(student1);
            course.addStudent(student2);

            // save students
            session.save(student1);
            session.save(student2);


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
