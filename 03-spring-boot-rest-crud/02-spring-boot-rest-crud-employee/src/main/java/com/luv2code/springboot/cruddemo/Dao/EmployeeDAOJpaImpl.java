package com.luv2code.springboot.cruddemo.Dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDao{

    //define field for entityManager

    private EntityManager entityManger;

    // set up constructor injection

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManger = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query

        TypedQuery<Employee> theQuery = entityManger.createQuery("from Employee",Employee.class);

        //execute query and get resultList

        List<Employee> employees = theQuery.getResultList();
        //return the list

        return employees;
    }

    @Override
    public Employee findById(int theId) {

        Employee employee = entityManger.find(Employee.class,theId);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        Employee dbEmployee = entityManger.merge(theEmployee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        //find employee by id
        Employee employee = entityManger.find(Employee.class,theId);

        //remove employee
        entityManger.remove(employee);

    }
}
