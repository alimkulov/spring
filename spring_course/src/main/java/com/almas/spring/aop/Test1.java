package com.almas.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary uniLibrary =context.getBean("uniLibrary", UniLibrary.class);
        Book book=context.getBean("book",Book.class);
        uniLibrary.getBook();
        uniLibrary.addBook("Almas",book);
        uniLibrary.addMagazine();
       // uniLibrary.getMagazine();
     //   uniLibrary.returnBook(14);
     //    uniLibrary.returnMagazine();


//        SchoolLibrary schoolLibrary =context.getBean("schoolLibrary", SchoolLibrary.class);
//        schoolLibrary.getBook();

        context.close();
    }
}
