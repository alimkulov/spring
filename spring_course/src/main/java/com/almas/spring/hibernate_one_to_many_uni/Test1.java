package com.almas.spring.hibernate_one_to_many_uni;




import com.almas.spring.hibernate_one_to_many_uni.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session =null;
        try {

//            session = factory.getCurrentSession();
//            Department dep=new Department("HR",1000,1300);
//            Employee emp1=new Employee("John", "A",900);
//            Employee emp2=new Employee("Ilon","M", 1200);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            session.beginTransaction();
//            session.save(dep);
//            session.getTransaction().commit();
//            System.out.println("Done!");

            session = factory.getCurrentSession();
            session.beginTransaction();
            Department dep=session.get(Department.class,2);

            System.out.println(dep);
            System.out.println(dep.getEmps());
            session.getTransaction().commit();
            System.out.println("Done!");

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Employee employee=session.get(Employee.class,1);
//            session.delete(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }

        }
}
