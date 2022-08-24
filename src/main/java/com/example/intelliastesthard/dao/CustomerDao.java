package com.example.intelliastesthard.dao;

import com.example.intelliastesthard.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {};
