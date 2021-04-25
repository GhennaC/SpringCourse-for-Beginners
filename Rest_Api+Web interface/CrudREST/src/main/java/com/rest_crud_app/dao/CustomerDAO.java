package com.rest_crud_app.dao;

import com.rest_crud_app.entity.Customer;

import java.util.List;



public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
