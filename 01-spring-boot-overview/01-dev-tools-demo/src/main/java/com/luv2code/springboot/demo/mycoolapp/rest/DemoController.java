package com.luv2code.springboot.demo.mycoolapp.rest;

import com.luv2code.springboot.demo.mycoolapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Define private field for dependency

    private Coach myCoach;


    //Define constructor for dependency injection

    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach theCoach){

        myCoach=theCoach;

    }

    //Setter injection

   /* @Autowired
    public void setCoach(Coach theCoach){
        myCoach=theCoach;
    }*/

  /*  Behind the scenes
     Coach theCach = new CricketCoach();
    DemoController demoController = new DemoController();
*/
    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){

        return myCoach.getDailyWorkout();
    }

    //To check bean scope
 /*   @GetMapping("/check")
    public String getCheck(){

        return "Comparing beans myCoach==yourCoach:- "+ (myCoach==yourCoach);
    }*/
}
