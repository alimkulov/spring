package com.almas.spring.aop.aspects;

import com.almas.spring.aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

//    @Pointcut("execution(* com.almas.spring.aop.UniLibrary.*(..))")
//    private void allMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(public void  com.almas.spring.aop.UniLibrary.returnMagazine())")
//    private void returnMagazineFromUniLibrary(){}
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniLibrary(){}
//
//    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineAdvice(){
//        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: Log#10");
//    }

//    @Pointcut("execution(* com.almas.spring.aop.UniLibrary.get*())")
//    private void allGetMethodFromUniLibrary(){}
//
//    @Pointcut("execution(* com.almas.spring.aop.UniLibrary.return*())")
//    private void allReturnMethodFromUniLibrary(){}
//
//    @Pointcut("allGetMethodFromUniLibrary() || allReturnMethodFromUniLibrary()")
//    private void allGetAndReturnMethodFromUniLibrary(){}
//
//    @Before("allGetMethodFromUniLibrary()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: writing log #1");
//    }
//
//    @Before("allReturnMethodFromUniLibrary()")
//    public void beforeReturnLoggingAdvice(){
//        System.out.println("beforeReturnLoggingAdvice: writing log #2");
//    }
//
//    @Before("allGetAndReturnMethodFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing log #3");
//    }


    //@Before("execution(public void com.almas.spring.aop.UniLibrary.getBook())")
   // @Before("execution(public void get*(String))")
   // @Before("execution(public void *(*))")
   // @Before("execution( * getBook(com.almas.spring.aop.Book))")
    @Before("com.almas.spring.aop.aspects.MyPoincuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint){

        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature="+methodSignature);
        System.out.println("methodSignature.getMethod()="+methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType()="+methodSignature.getReturnType());
        System.out.println("methodSignature.getName()="+methodSignature.getName());

        if(methodSignature.getName().equals("addBook")){
            Object[] arguments=joinPoint.getArgs();

            for(Object obj:arguments){
                if(obj instanceof Book){
                    Book myBook= (Book) obj;
                    System.out.println("Info about book: name-"+
                            myBook.getName()+" author-"+myBook.getAuthor()+" year pub-"+myBook.getYearOfPublication());
                }
                else if(obj instanceof String){
                    System.out.println("the book was added by "+obj);
                }
            }
        }

        System.out.println("beforeAddLoggingAdvice: logging  attempt to get a book/ magazine");
        System.out.println("-------------------------------------------------");
    }



//    @Before("execution(public * returnBook())")
//    public void beforeReturnBookAdvice(){
//        System.out.println("beforeReturnBookAdvice: attempt to return a book");
//    }
}
