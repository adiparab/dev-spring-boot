package com.luv2code.springboot.demo.mycoolapp.common;

public class SwimCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Swim 100m as a warm up";
    }
}
