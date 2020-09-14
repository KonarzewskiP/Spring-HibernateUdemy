package hibernate.demo;

import hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentsDemo {

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

            // get the instructor from db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            // create a course
            Course tempCourse = new Course("Pacman - How to score one million points.");

            // save the course
            System.out.println("\nSave the course...");
            session.save(tempCourse);
            System.out.println("Save the course: " + tempCourse);

            // create the students
            Student tempStudent1 = new Student("Barack", "Obama", "white@house.com");
            Student tempStudent2 = new Student("Abraham", "Lincoln", "abri@cookie.com");
            Student tempStudent3 = new Student("Ronald", "Reagan", "Ronald@RR.com");

            // add students to the course
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);
            tempCourse.addStudent(tempStudent3);

            // save the students
            System.out.println("\nSaving students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            System.out.println("Saved students: " + tempCourse.getStudents());


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
