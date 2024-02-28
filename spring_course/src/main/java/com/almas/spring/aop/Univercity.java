package com.almas.spring.aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Univercity {

    private List<Student> students=new ArrayList<>();

    public void addStudent(){

        Student st1=new Student("John", 4, 7.5);
        Student st2=new Student("Alice", 1, 7.2);
        Student st3=new Student("Sean", 3, 6.1);

        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student>  getStudents(){
        System.out.println("Start of working method getStudents");
        System.out.println(students.get(3));
        System.out.println("Info from method getStudents:");
        System.out.println(students);
        return students;
    }


}


