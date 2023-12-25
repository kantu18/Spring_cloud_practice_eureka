package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Phones;
import com.example.demo.entity.Product_info;
import com.example.demo.repository.Product_repo;

@Service
public class Product_service {

		@Autowired
		private Phone_feign_client client;
		
		@Autowired
		private Product_repo product_repo;
		
		public List<Product_info> findAllCustomers(){
			return product_repo.findAll();
		}
		
		public Product_info savecustomers(Product_info customer)
		{
			return product_repo.save(customer);
		}
		
		public Optional<Product_info> findCustomersDetails(Integer id)
		{
			return product_repo.findById(id);
		}
		
		
		public Product_info fetch_phones(Integer prod_id) throws Exception
		{
			Product_info customer= product_repo.findById(prod_id).orElseThrow(()-> new Exception());
			
			Phones phones = client.getPhones(prod_id);
			
			customer.setPhone(phones);
			
			return customer;
		}
		
		public Product_info create_phones(Phones phone) throws Exception
		{
			Product_info customer= product_repo.findById(phone.getProd_id()).orElseThrow(()-> new Exception());
			
			Phones phones = client.saveorUpdatePhones(phone);
			phones.setProd_id(phone.getProd_id());
			phones.setPrice(phone.getPrice());
			phones.setPhone_id(phone.getPhone_id());
			phones.setFeedback(phone.getFeedback());
			phones.setName(phone.getName());
			
			customer.setPhone(phones);
			
			return customer;
		}
	}

