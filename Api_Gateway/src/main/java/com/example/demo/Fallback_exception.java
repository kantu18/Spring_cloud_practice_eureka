package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Fallback_exception {

	@GetMapping("/fallbackuser")
	public String User_service_exception()
	{
		return "No User_Details Available now, try again later";
	}
	
	@GetMapping("/fallbackproduct")
	public String Product_service_exception()
	{
		return "No Product_details Available now, try again later";
	}
	
	@GetMapping("/fallbackphones")
	public String Phone_service_exception()
	{
		return "No Phones Available now, try again later";
	}
}
