package com.almas.spring.hibernate_one_to_many_bi;



import com.almas.spring.hibernate_one_to_many_bi.entity.Department;
import com.almas.spring.hibernate_one_to_many_bi.entity.Employee;
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
//            Department dep=new Department("Sales",800,1500);
//            Employee emp1=new Employee("Almas", "A",800);
//            Employee emp2=new Employee("Ivan","T", 1500);
//            Employee emp3=new Employee("Anton","S", 1200);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//
//            session.beginTransaction();
//            session.save(dep);
//            session.getTransaction().commit();
//            System.out.println("Done!");
//******************************************************************
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Get department");
            Department dep=session.get(Department.class,3);

            System.out.println("Show dep");
            System.out.println(dep);

            System.out.println("Show emps of dep");
            System.out.println(dep.getEmps());
            session.getTransaction().commit();
            System.out.println("Done!");
//******************************************************************
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
