package com.example.demo.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product_info;
import com.example.demo.repository.Customer_repository;

@Service
public class Customer_Service {

	@Autowired
	private Customer_repository customer_repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Customer> findAllCustomers(){
		return customer_repository.findAll();
	}
	
	public Customer savecustomers(Customer customer)
	{
		return customer_repository.save(customer);
	}
	
	public Optional<Customer> findCustomersDetails(int id)
	{
		return customer_repository.findById(id);
	}
	
	//Using Resttemplate to connect to separate microservices internally through passing the URL and the Class Type
	//with the get for object method.
	public Customer fetch_Users(Integer user_id) throws Exception
	{
		Customer customer= customer_repository.findById(user_id).orElseThrow(()-> new Exception());
		
		Product_info objlist= restTemplate.getForObject("http://PRODUCT-SERVICE/product_info/findbyid/1", Product_info.class);
		
		customer.setProd_list(objlist);
		
		return customer;
	}
}
