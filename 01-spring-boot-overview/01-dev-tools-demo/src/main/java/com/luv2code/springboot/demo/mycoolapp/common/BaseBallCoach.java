package com.luv2code.springboot.demo.mycoolapp.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class BaseBallCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Lets practice base ball";
    }
}
