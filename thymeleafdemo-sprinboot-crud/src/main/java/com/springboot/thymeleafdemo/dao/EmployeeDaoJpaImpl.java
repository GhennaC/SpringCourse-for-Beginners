package com.springboot.thymeleafdemo.dao;

import com.springboot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query =
                entityManager.createQuery("from Employee",Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = entityManager.find(Employee.class,id);

        return employee;
    }

    @Override
    public void save(Employee employee) {

        Employee employee1 = entityManager.merge(employee);

        employee.setId(employee1.getId());
    }

    @Override
    public void delete(int id) {

        Query query = entityManager.createQuery(
                "delete from Employee where id=:id"
        );

        query.setParameter("id",id);
        query.executeUpdate();

    }
}
