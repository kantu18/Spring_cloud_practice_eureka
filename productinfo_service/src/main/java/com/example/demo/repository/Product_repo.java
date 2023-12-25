package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product_info;

@Repository
public interface Product_repo extends JpaRepository<Product_info, Integer>{

}
