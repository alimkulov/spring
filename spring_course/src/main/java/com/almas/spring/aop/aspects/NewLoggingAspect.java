package com.almas.spring.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: it is trying to return the book to Library");

        Object targetMethodResult=null;
      //  long begin= System.currentTimeMillis();
       try {
           targetMethodResult = proceedingJoinPoint.proceed();
           //  long end=System.currentTimeMillis();
       }
       catch(Exception e){
           System.out.println("aroundReturnBookLoggingAdvice: it has been caught exception: "+ e);
           // targetMethodResult="unknown book name";
           throw e;
       }
        System.out.println("aroundReturnBookLoggingAdvice: the book was successfully returned to Library");
       // System.out.println("aroundReturnBookLoggingAdvice: returnBook meth completed task on:"+ (end-begin)+" ms");

        return targetMethodResult;
    }
}
