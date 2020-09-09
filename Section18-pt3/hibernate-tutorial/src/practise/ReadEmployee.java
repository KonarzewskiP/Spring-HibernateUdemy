package practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import practise.entity.Employee;

public class ReadEmployee {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try(factory){
            long employeeId = 1;

            // create current session
            Session session = factory.getCurrentSession();

            //start transaction
            session.beginTransaction();

            //get employee
            Employee tempEmployee = session.get(Employee.class,employeeId);

            System.out.println("Get completed: " + tempEmployee);

            System.out.println("Done!");
        }
    }
}
