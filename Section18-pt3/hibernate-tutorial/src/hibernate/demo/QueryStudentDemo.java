package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // without ("hibernate.cfg.xml") hibernate will implicitly
                // search for this folder.
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        // use the session object to save Java object
        try {

            // start transaction
            session.beginTransaction();

            // query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            // display students
            DisplayStudents(theStudents);

            // query students: lastName='Sklodowska-Curie'
            theStudents = session.createQuery("from Student s where s.lastName='Sklodowska-Curie'").getResultList();

            // display students
            System.out.println("\n\nStudens who have last name of Sklodowska-Curie");
            DisplayStudents(theStudents);

            //query students: lastName="Newton' OR firstName='Elon'
            theStudents =
                    session.createQuery("from Student s where "
                            +"s.lastName='Newton' OR s.firstName='Elon'").getResultList();

            // display students
            System.out.println("\n\nStudens who have lastName='Newton' OR firstName='Elon'");
            DisplayStudents(theStudents);

            //query students where email LIKE '%.com'
            theStudents =
                    session.createQuery("from Student s where "
                            +"s.email LIKE '%.com'").getResultList();

            // display students
            System.out.println("\n\nStudens whos emial ends with '.com'");
            DisplayStudents(theStudents);

            //query students where email LIKE '%gmail.com'
            theStudents =
                    session.createQuery("from Student s where "
                            +"s.email LIKE '%gmail.com'").getResultList();

            // display students
            System.out.println("\n\nStudens whos emial ends with 'gmail.com'");
            DisplayStudents(theStudents);
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }


    }

    private static void DisplayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }
}
