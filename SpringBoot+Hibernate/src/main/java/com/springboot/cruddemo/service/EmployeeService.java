package com.springboot.cruddemo.service;

import com.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee getEmployee(int id);

    public void save(Employee employee);

    public void delete(int id);

}
