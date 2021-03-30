package pl.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.ManyToMany.entities.*;


public class DemoAddCoursesToStudent {

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
            int id = 1;
            Student student = session.get(Student.class,id);

            System.out.println("Student courses: " + student.getCourseList());
            System.out.println();
            // create some courses
            Course course1 = new Course("Building");
            Course course2 = new Course("Play guitar");
            //Course course3 = new Course("Play voleyball");


            // add student to courses
            course1.addStudent(student);
            course2.addStudent(student);
            //student.addCourse(course3);

            // save the courses
            session.save(course1);
            session.save(course2);
            //session.save(student);

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
