package practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import practise.entity.Employee;

public class DeleteEmployee {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try(factory){
            // create current session
            Session session = factory.getCurrentSession();

            // begin session
            session.beginTransaction();

            // get Employee
            Employee employee = session.get(Employee.class, 2L);

            // Delete employee
            session.delete(employee);

            // Delete employee
            session.createQuery("delete from Employee where id=3").executeUpdate();

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
