package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

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
        try{
            // create 3 student objects
            System.out.println("Creating new studen object...");
            Student tempStudent1 = new Student("Steve","Jobs","Steve@apple.com");
            Student tempStudent2 = new Student("Elon","Musk","boss@spaceX.com");
            Student tempStudent3 = new Student("Isaac","Newton","newton@Cambridge.uk");

            // start transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }


    }
}
