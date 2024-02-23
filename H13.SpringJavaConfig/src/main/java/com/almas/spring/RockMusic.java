package com.almas.spring;

//@Component("rockMusic")
public class RockMusic implements Music{
    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}
