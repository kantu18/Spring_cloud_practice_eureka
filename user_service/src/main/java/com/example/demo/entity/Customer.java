package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	
	@Column(name="user_name")
	private String user_name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="review")
	private String review;
	
	@Column(name="phone_no")
	private Long phone_no;
	
	@Transient
	private Product_info prod_list;

	public Customer() {
		super();
	}
	
	public Customer(Integer user_id, String user_name, String address, String review, Long phone_no,
			Product_info prod_list) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.address = address;
		this.review = review;
		this.phone_no = phone_no;
		this.prod_list = prod_list;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}

	public Product_info getProd_list() {
		return prod_list;
	}

	public void setProd_list(Product_info objlist) {
		this.prod_list = objlist;
	}

	@Override
	public String toString() {
		return "Customer [user_id=" + user_id + ", user_name=" + user_name + ", address=" + address + ", review="
				+ review + ", phone_no=" + phone_no + ", prod_list=" + prod_list + "]";
	}

	
}
