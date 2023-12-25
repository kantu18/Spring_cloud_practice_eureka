package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.Customer_Service;

import ch.qos.logback.classic.Logger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customer")
@Slf4j
public class Customer_Controller {

	@Autowired
	private Customer_Service customer_Service;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Customer>> findAllCustomer_details(){
		return new ResponseEntity<List<Customer>>(customer_Service.findAllCustomers(), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomers(@RequestBody Customer customer)
	{
		return new ResponseEntity<Customer>(customer_Service.savecustomers(customer), HttpStatus.CREATED);
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findCustomerbyID(@PathVariable Integer id)
	{
		
		Optional<Customer> findCustomersDetails = customer_Service.findCustomersDetails(id);
		
		if(findCustomersDetails.isPresent())
		{
			Optional<String> reviewcheck= Optional.ofNullable(findCustomersDetails.get().getReview());
			
			if(reviewcheck.isPresent())
			{
				return new ResponseEntity<Optional<Customer>>(customer_Service.findCustomersDetails(id),HttpStatus.ACCEPTED);
			}else {
				return new ResponseEntity<Optional<Customer>>(HttpStatus.NOT_FOUND).ok("THERE IS NO REVIEW FOR THIS USER");
			}
		
		}else {
			return new ResponseEntity<Optional<Customer>>(HttpStatus.NOT_FOUND).ok("USER DETAILS FOUND WITH SPECIFIC ID DOES NOT EXIST");
		
		}
	}
	
	@GetMapping("/fetchdetails/{user_id}")
	@CircuitBreaker(name = "customer_fallback", fallbackMethod = "fallbackcustomer")
	public ResponseEntity<Customer> fetchdetails(@PathVariable Integer user_id) throws Exception
	{
		return new ResponseEntity<Customer>(customer_Service.fetch_Users(user_id), HttpStatus.ACCEPTED);
	}
	
	
	//Fallback method for the circuit breaker should have same return type as the orginal method which is anotated
	
	public ResponseEntity<Customer> fallbackcustomer(Integer user_id, Exception e) throws Exception
	{
		Customer cusobj=new Customer();
		cusobj.setUser_name("Helper");
		cusobj.setUser_id(1821);
		cusobj.setAddress("help.com");
		cusobj.setReview("Customer_details are not available try again later");
		
		return new ResponseEntity<Customer>(cusobj, HttpStatus.OK);
	}
	
	
}
