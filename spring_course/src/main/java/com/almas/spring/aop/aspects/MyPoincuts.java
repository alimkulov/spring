package com.almas.spring.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPoincuts {

    @Pointcut("execution(* adc*(..))")
    public void allAddMethods(){}
}
