package hibernate.demo;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // without ("hibernate.cfg.xml") hibernate will implicitly
                // search for this folder.
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        // use the session object to save Java object
        try {

            // start transaction
            session.beginTransaction();

            // get a course
            int theId = 11;
            Course tempCourse = session.get(Course.class, theId);

            // delete course
            System.out.println("Deleting course: " + tempCourse);
            session.delete(tempCourse);

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
