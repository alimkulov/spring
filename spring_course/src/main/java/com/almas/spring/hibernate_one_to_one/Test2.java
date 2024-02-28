package com.almas.spring.hibernate_one_to_one;


import com.almas.spring.hibernate_one_to_one.entity.Detail;
import com.almas.spring.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session =null;
        try {
//            session = factory.getCurrentSession();
//            Employee emp = new Employee("Misha", "U", "HR", 950);
//            Detail detail=new Detail("London","989878745","olikujd@asdas");
//
//            emp.setEmpDetail(detail);
//            detail.setEmployee(emp);
//            session.beginTransaction();
//            session.save(emp);

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Detail detail=session.get(Detail.class,3);
//            System.out.println(detail.getEmployee());

            session = factory.getCurrentSession();
            session.beginTransaction();
            Detail detail=session.get(Detail.class,1);
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }

        }
}
