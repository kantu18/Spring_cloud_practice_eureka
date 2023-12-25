package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Phones;
import com.example.demo.repository.Phone_repository;


@Service
public class Phone_service {

		@Autowired
		private Phone_repository phone_repository;
		
		public List<Phones> findAllphones(){
			return phone_repository.findAll();
		}
		
		public Phones savecustomers(Phones ph)
		{
			return phone_repository.save(ph);
		}
		
		public Optional<Phones> findCustomersDetails(Integer phone_id)
		{
			return phone_repository.findById(phone_id);
		}
		
	}

