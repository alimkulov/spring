package com.almas.spring.aop.aspects;

import com.almas.spring.aop.Student;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* com.almas.spring.aop.Univercity.getStudents())")
    public void beforeGetStudentsLoggingAdvice(){
        System.out.println("beforeGetStudentsLoggingAdvice: logging getting list of students before methods getStudents");
    }

//    @AfterReturning(pointcut="execution(* com.almas.spring.aop.Univercity.getStudents())",
//                     returning = "students")
//    public void afterReturningGetStudentsLoggingAdvice(List<Student> students){
//        Student firstStudent=students.get(0);
//
//        String nameSurname= firstStudent.getNameSurname();
//        nameSurname="Mr" +nameSurname;
//        firstStudent.setNameSurname(nameSurname);
//
//        double avgGrade= firstStudent.getAvgGrade();
//        avgGrade=avgGrade+1;
//        firstStudent.setAvgGrade(avgGrade);
//
//
//
//        System.out.println("afterReturningGetStudentsLoggingAdvice: logging getting list of students After complete methods getStudents");
//    }

//    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
//    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception) {
//        System.out.println("afterThrowingGetStudentsLoggingAdvice: logging throw exception "+exception);
//    }

    @After("execution(* getStudents())")
    public void afterGetStudentLoggingAdvice(){
        System.out.println("afterGetStudentLoggingAdvice: logging normal ending of method or throw exception");
    }
}
