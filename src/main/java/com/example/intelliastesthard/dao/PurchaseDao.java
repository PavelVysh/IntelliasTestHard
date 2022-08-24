package com.example.intelliastesthard.dao;

import com.example.intelliastesthard.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseDao extends JpaRepository<Purchase,Integer> {
}
