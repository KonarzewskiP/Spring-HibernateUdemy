package practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.internal.ast.tree.SessionFactoryAwareNode;
import practise.entity.Employee;

import java.util.Date;
import java.util.Iterator;

public class UpdateEmployee {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try (factory) {

            Session session = factory.getCurrentSession();

            session.beginTransaction();

            String theStartDate = "01/05/1996";

            Date startDate = DateUtils.parseDate(theStartDate);

            Employee tempEmployee = session.get(Employee.class, 5L);
            System.out.println(tempEmployee);

            tempEmployee.setStartDate(startDate);

            System.out.println(tempEmployee);
            session.getTransaction().commit();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
