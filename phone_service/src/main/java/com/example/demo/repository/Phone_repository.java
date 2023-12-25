package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Phones;

@Repository
public interface Phone_repository extends JpaRepository<Phones, Integer>{

}
