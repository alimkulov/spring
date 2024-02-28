package com.almas.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary{
    //@Override
    public void getBook() {
        System.out.println("You get a book from the School");
    }
}
