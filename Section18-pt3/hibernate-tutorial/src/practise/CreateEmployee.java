package practise;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import practise.entity.Employee;

import java.util.Date;

public class CreateEmployee {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();



        try (factory) {
            // create current session
            Session session = factory.getCurrentSession();

            String theStartDate = "01/05/1996";

            Date startDate = DateUtils.parseDate(theStartDate);
            //create a employee object
            Employee newEmployee = new Employee("Jeff", "Bezos", "Amazon",startDate);

            //start transaction
            session.beginTransaction();

            //save the employee object
            System.out.println("Save: "+newEmployee.toString());
            session.save(newEmployee);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
