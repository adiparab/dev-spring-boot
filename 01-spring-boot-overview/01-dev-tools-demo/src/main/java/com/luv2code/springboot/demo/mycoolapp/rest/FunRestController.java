package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //expose "/" that return hello word

    @GetMapping("/")
    public String satHello(){

        return "Hello in this World aditya!";
    }

    @GetMapping("/workout")
    public String getWorkout(){

        return "Run a hard 5k";
    }

    @GetMapping("/fortune")
    public String getFortune(){

        return "Today is good day";
    }

    //inject properties for: coach.name and team.name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //expose new endpoint for "teaminfo"

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
   return "Coach name: "+coachName+ " Team name: "+ teamName;
    }


}
