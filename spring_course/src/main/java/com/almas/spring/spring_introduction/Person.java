package com.almas.spring.spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("personBean")
public class Person {
//    @Autowired
//    @Qualifier("dog")
    private  Pet pet;
    @Value("${person.surname}")
    private  String surname;
    @Value("${person.age}")
    private int age;

//    @Autowired
//    public Person(@Qualifier("dog") Pet pet) {
//        System.out.println("Pearson bean is created");
//        this.pet = pet;
//    }

        public Person(Pet pet) {
            System.out.println("Pearson bean is created");
            this.pet = pet;
        }

    public void setSurname(String surname) {
        System.out.println("Class Person: set surname");
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        System.out.println("Class Age:set age");
        this.age = age;
    }

   // @Autowired
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void callYourPet(){
        System.out.println("Hello, my lovely pet");
        pet.say();
    }
}
