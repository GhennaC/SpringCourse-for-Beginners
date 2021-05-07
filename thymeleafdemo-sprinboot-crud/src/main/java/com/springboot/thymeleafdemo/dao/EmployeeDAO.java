package com.springboot.thymeleafdemo.dao;


import com.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee getEmployee(int id);

    public void save(Employee employee);

    public void delete(int id);
}
