package com.almas.spring.aop;

import org.springframework.stereotype.Component;

import java.lang.invoke.StringConcatFactory;

@Component
public class UniLibrary extends AbstractLibrary{
  //  @Override
    public void getBook(){
        System.out.println("You get a book from the University ");
        System.out.println("-------------------------------------------------");
    }

    public String returnBook(){
        int a=10/0;
        System.out.println("we return the book to University");

        return  "War and Peace";
    }

    public void getMagazine(){
        System.out.println("You get a Magazine from the University");
        System.out.println("-------------------------------------------------");
    }

    public void returnMagazine(){
        System.out.println("we return the magazine to University");
        System.out.println("-------------------------------------------------");
    }

    public void addBook(String personName, Book book) {
        System.out.println("we add book to UniLibrary");
        System.out.println("-------------------------------------------------");
    }

    public void addMagazine() {
        System.out.println("we add magazine to UniLibrary");
        System.out.println("-------------------------------------------------");
    }


}
