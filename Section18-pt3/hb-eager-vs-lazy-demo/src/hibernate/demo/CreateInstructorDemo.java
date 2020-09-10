package hibernate.demo;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

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

            // create the objects

            Instructor tempInstructor = new Instructor("Chris", "Heria", "chris@heria.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail(
                    "https://www.youtube.com/chrisheria",
                    "Calisthenic");

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // start transaction
            session.beginTransaction();

             /*
             save the instructor
             NOTE: this will also save the details object
             because of CascadeType.ALL
             */
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);


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
