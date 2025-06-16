package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.Dao.EmployeeDAOJpaImpl;
import com.luv2code.springboot.cruddemo.Dao.EmployeeDao;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao theEmployeeDao){

        this.employeeDao = theEmployeeDao;

    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDao.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDao.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeDao.deleteById(theId);
    }
}
