package com.springboot.thymeleafdemo.dao;

import com.springboot.thymeleafdemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Employee> query =
                currentSession.createQuery("from Employee",Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee getEmployee(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Employee employee = currentSession.get(Employee.class,id);

        return employee;
    }

    @Override
    public void save(Employee employee) {

        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(employee);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery(
                "delete from Employee where id=:id"
        );
        query.setParameter("id",id);
        query.executeUpdate();
    }

}
