package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.Dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){

        this.employeeRepository = theEmployeeRepository;

    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;

        if(result.isPresent()){

            theEmployee=result.get();
        }else{

            throw new RuntimeException("Did not find employee id "+theId);
        }
        return theEmployee;
    }


    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

 
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
