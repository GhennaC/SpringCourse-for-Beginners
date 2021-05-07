package com.springboot.thymeleafdemo.service;

import com.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee getEmployee(int id);

    public void save(Employee employee);

    public void delete(int id);

}
