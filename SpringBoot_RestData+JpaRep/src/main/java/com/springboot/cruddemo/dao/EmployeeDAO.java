package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee getEmployee(int id);

    public void save(Employee employee);

    public void delete(int id);
}
