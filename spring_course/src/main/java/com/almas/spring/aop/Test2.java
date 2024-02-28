package com.almas.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext  context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Univercity univercity=context.getBean("univercity", Univercity.class);
        univercity.addStudent();
        try {
            List<Student> students = univercity.getStudents();
            System.out.println(students);
        } catch (Exception e) {
            System.out.println("Exception was caught:"+e);
        }

        context.close();
    }
}
