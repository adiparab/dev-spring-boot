package com.luv2code.springboot.cruddemo.Dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //That's it we are now using inbuilt functions of JPA repository
}
