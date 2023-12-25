package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class Product_info {

	private String prod_id;
	private Integer user_id;
	private Double price;
	private String feedback;
	
	public Product_info() {
		super();
	}
	
	
	public Product_info(String prod_id, Integer user_id, Double price, String feedback) {
		super();
		this.prod_id = prod_id;
		this.user_id = user_id;
		this.price = price;
		this.feedback = feedback;
	}


	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Product_info [prod_id=" + prod_id + ", user_id=" + user_id + ", price=" + price + ", feedback="
				+ feedback + "]";
	}
	
}
