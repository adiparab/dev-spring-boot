package com.luv2code.springboot.cruddemo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeServiceImpl employeeService;

    private ObjectMapper objectMapper;


    //quick and dirty : inject employee dao
   public EmployeeRestController(EmployeeServiceImpl theEmployeeService, ObjectMapper theObjectMapper){
       employeeService=theEmployeeService;
       objectMapper =theObjectMapper;

   }

    // expose "/employee" and return a list of employees

    @GetMapping("/employees")
    public List<Employee> findAll(){
       return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

       Employee theEmployee = employeeService.findById(employeeId);
       if(theEmployee==null){

           throw new RuntimeException("Employee Id not found: "+employeeId);
       }
       return theEmployee;
    }


    // add mapping for POST /employees - add new memployee

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

       //also just in case they pass an id in json ... set id to 0
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

       Employee updatedEmployee = employeeService.save(theEmployee);

       return updatedEmployee;
    }

    //add mapping for delete /employees - delete employee by id

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

       String response ="";
       try {
           employeeService.deleteById(employeeId);

           response="employee deleted";
       } catch (Exception e) {

           response = "Found error";
          //return response;
           throw new RuntimeException("Employee not found for given id");
       }


        return response;

    }


    //Add mapping for PATCH -- partial update

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload){

       Employee tempEmployee = employeeService.findById(employeeId);

       if(tempEmployee == null){
           throw new RuntimeException("Employee Id not found");

       }
       //Throw exception if request body contains ID (bcz its primary key)

        if(patchPayload.containsKey("id")){
            throw new RuntimeException("Employee id not allowed in request body");
        }

        Employee pathchedEmployee = apply(patchPayload,tempEmployee);

        Employee dbEmployee = employeeService.save(pathchedEmployee);

        return dbEmployee;
    }

    private Employee apply(Map<String, Object> patchPayload, Employee tempEmployee) {

       //convert employee object to json object node

        ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);

        //convert patch employee object to json object

        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }
}
