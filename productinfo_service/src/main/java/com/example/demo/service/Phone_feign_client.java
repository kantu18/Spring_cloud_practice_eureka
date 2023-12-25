package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Phones;

@FeignClient(name="PHONE-SERVICE")
public interface Phone_feign_client {

	@GetMapping("/phones/findbyid/{phone_id}")
	Phones getPhones(@PathVariable("phone_id") Integer phone_id);
	
	@PostMapping("/phones/save")
	Phones saveorUpdatePhones(Phones ph);
}
