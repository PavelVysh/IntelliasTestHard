package com.example.intelliastesthard.dao;

import com.example.intelliastesthard.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
