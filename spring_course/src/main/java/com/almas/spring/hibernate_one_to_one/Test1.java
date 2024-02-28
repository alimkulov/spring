package com.almas.spring.hibernate_one_to_one;


import com.almas.spring.hibernate_one_to_one.entity.Detail;
import com.almas.spring.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session =null;
        try {
//            Session session = factory.getCurrentSession();
//            Employee emp = new Employee("Ivan", "T", "Sales", 750);
//            Detail detail=new Detail("NY","12345","asdasd@asdas");
//            emp.setEmpDetail(detail);
//            session.beginTransaction();
//            session.save(emp);
//            session.getTransaction().commit();
//            System.out.println("Done!");

//            Session session = factory.getCurrentSession();
//            Employee emp = new Employee("Oleg", "R", "HR", 250);
//            Detail detail=new Detail("Moscow","465445","dfgdfgdasd@asdas");
//            emp.setEmpDetail(detail);
//            session.beginTransaction();
//            session.save(emp);
//            session.getTransaction().commit();
//            System.out.println("Done!");

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee emp=session.get(Employee.class,10);
//            System.out.println(emp.getEmpDetail());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee emp=session.get(Employee.class,2);
            session.delete(emp);

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }

        }
}
