package com.example.demo.entity;


public class Phones {

	private Integer phone_id;
	private Integer prod_id;
	private Double price;
	private String feedback;
	private String name;
	
	public Phones() {
		super();
	}

	public Phones(Integer phone_id, Integer prod_id, Double price, String feedback, String name) {
		super();
		this.phone_id = phone_id;
		this.prod_id = prod_id;
		this.price = price;
		this.feedback = feedback;
		this.name = name;
	}

	public Integer getPhone_id() {
		return phone_id;
	}

	public void setPhone_id(Integer phone_id) {
		this.phone_id = phone_id;
	}

	public Integer getProd_id() {
		return prod_id;
	}

	public void setProd_id(Integer prod_id) {
		this.prod_id = prod_id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Phones [phone_id=" + phone_id + ", prod_id=" + prod_id + ", price=" + price + ", feedback=" + feedback
				+ ", name=" + name + "]";
	}
	
}
