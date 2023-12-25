package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Phones;
import com.example.demo.entity.Product_info;
import com.example.demo.service.Product_service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/product_info")
public class Product_info_Controller {

	@Autowired
	private Product_service product_service;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Product_info>> findAllproduct_details(){
		return new ResponseEntity<List<Product_info>>(product_service.findAllCustomers(), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Product_info> saveProducts(@RequestBody Product_info customer)
	{
		return new ResponseEntity<Product_info>(product_service.savecustomers(customer), HttpStatus.CREATED);
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Optional<Product_info>> findProductbyID(@PathVariable Integer id)
	{
		return new ResponseEntity<Optional<Product_info>>(product_service.findCustomersDetails(id), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/fetchphone/{prod_id}")
	@CircuitBreaker(name = "customer_exception", fallbackMethod = "fallbackproduct")
	public ResponseEntity<Product_info> fetchdetails(@PathVariable Integer prod_id) throws Exception
	{
		return new ResponseEntity<Product_info>(product_service.fetch_phones(prod_id), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/savebyfeign")
	@CircuitBreaker(name = "product_fallback", fallbackMethod = "fallbackproduct")
	public ResponseEntity<Product_info> saveProductsbyfeign(@RequestBody Phones ph) throws Exception
	{
		return new ResponseEntity<Product_info>(product_service.create_phones(ph), HttpStatus.CREATED);
	}
	
	public ResponseEntity<Product_info> fallbackproduct(Integer prod_id, Exception ex) throws Exception
	{
		Product_info cusobj=new Product_info();
		cusobj.setFeedback("Customer_details are not available try again later");
		cusobj.setUser_id(1821);
		cusobj.setProd_id(1821);
		
		return new ResponseEntity<Product_info>(cusobj, HttpStatus.OK);
	}
}

