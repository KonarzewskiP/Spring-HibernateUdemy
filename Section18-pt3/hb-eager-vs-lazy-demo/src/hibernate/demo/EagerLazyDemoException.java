package hibernate.demo;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemoException {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // without ("hibernate.cfg.xml") hibernate will implicitly
                // search for this folder.
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        // use the session object to save Java object
        try {

            // start transaction
            session.beginTransaction();

            // get the instructor from db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("luv2code: Instructor: " + tempInstructor);


            // commit transaction
            session.getTransaction().commit();

            //close te session
            session.close();

            // since courses are lazy loaded ... this should fail

            // get courses for the instructor
            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());

            System.out.println("luv2code: Done!");

        } finally {

            // add clean up code

            session.close();

            factory.close();
        }


    }
}
