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
import com.example.demo.service.Phone_service;

@RestController
@RequestMapping("/phones")
public class Phone_Controller {

	@Autowired
	private Phone_service product_service;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Phones>> findAllproduct_details(){
		return new ResponseEntity<List<Phones>>(product_service.findAllphones(), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Phones> saveProducts(@RequestBody Phones customer)
	{
		return new ResponseEntity<Phones>(product_service.savecustomers(customer), HttpStatus.CREATED);
	}
	
	@GetMapping("/findbyid/{phone_id}")
	public ResponseEntity<Optional<Phones>> findProductbyID(@PathVariable Integer phone_id)
	{
		return new ResponseEntity<Optional<Phones>>(product_service.findCustomersDetails(phone_id), HttpStatus.ACCEPTED);
	}
}
