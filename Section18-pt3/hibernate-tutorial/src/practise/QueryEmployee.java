package practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import practise.entity.Employee;

import java.util.List;

public class QueryEmployee {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try(factory){

            Session session = factory.getCurrentSession();

            session.beginTransaction();

            List<Employee> employeeList = session.createQuery("from Employee s where s.company like 'A%'").getResultList();

            for (Employee e :employeeList) {
                System.out.println(e.toString());
            }
        }
    }
}
