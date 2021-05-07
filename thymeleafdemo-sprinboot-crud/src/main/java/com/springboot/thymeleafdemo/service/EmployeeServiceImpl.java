package com.springboot.thymeleafdemo.service;

import com.springboot.thymeleafdemo.dao.EmployeeDAO;
import com.springboot.thymeleafdemo.dao.EmployeeJpaData;
import com.springboot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;
    private EmployeeJpaData employeeJpaData;

    @Autowired
    public EmployeeServiceImpl(EmployeeJpaData employeeJpaData) {
        this.employeeJpaData = employeeJpaData;
    }

    @Override
    public List<Employee> findAll() {
        return employeeJpaData.findAllByOrderByLastNameAsc();
    }


    @Override
    public Employee getEmployee(int id) {
        Optional<Employee> byId = employeeJpaData.findById(id);
        Employee employee = null;

        if(byId.isPresent()) {
            employee = byId.get();
        }
        else {
            throw new RuntimeException("Did not find employee" + id);
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeJpaData.save(employee);

    }

    @Override
    public void delete(int id) {
        employeeJpaData.deleteById(id);
    }
}
