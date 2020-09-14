package hibernate.demo;

import hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForBarackDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // without ("hibernate.cfg.xml") hibernate will implicitly
                // search for this folder.
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        // use the session object to save Java object
        try {

            // start transaction
            session.beginTransaction();

            // get the student Barack from DB
            int idStudent = 2;
            Student barackStudent = session.get(Student.class, idStudent);
            System.out.println("\nLoaded student: " + barackStudent);
            System.out.println("\nCourses: " + barackStudent.getCourses());


            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            // add clean up code

            session.close();

            factory.close();
        }


    }
}
