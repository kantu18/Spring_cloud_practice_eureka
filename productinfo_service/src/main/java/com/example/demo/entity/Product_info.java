package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="Product_info")
public class Product_info {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prod_id;
	
	@Column(name="user_id")
	private Integer user_id;
	
	@Column(name="Price")
	private Double price;
	
	@Column(name="feedback")
	private String feedback;

	@Transient
	private Phones phone;
	
	public Product_info() {
		super();
	}

	public Product_info(Integer prod_id, Integer user_id, Double price, String feedback, Phones phone) {
		super();
		this.prod_id = prod_id;
		this.user_id = user_id;
		this.price = price;
		this.feedback = feedback;
		this.phone = phone;
	}

	public Integer getProd_id() {
		return prod_id;
	}

	public void setProd_id(Integer prod_id) {
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

	public Phones getPhone() {
		return phone;
	}

	public void setPhone(Phones phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Product_info [prod_id=" + prod_id + ", user_id=" + user_id + ", price=" + price + ", feedback="
				+ feedback + ", phone=" + phone + "]";
	}

}
