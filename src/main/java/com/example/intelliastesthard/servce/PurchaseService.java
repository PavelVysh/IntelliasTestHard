package com.example.intelliastesthard.servce;

import com.example.intelliastesthard.dao.CustomerDao;
import com.example.intelliastesthard.dao.ProductDao;
import com.example.intelliastesthard.dao.PurchaseDao;
import com.example.intelliastesthard.entity.Customer;
import com.example.intelliastesthard.entity.Product;
import com.example.intelliastesthard.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PurchaseService {
    private final PurchaseDao purchaseDao;
    private final ProductDao productDao;
    private final CustomerDao customerDao;

    public PurchaseService(PurchaseDao purchaseDao, ProductDao productDao,
                           CustomerDao customerDao) {
        this.purchaseDao = purchaseDao;
        this.productDao = productDao;
        this.customerDao = customerDao;
    }

    public void makePurchase(int CustomerId, int ProductId) {
        Optional<Customer> customer = customerDao.findById(CustomerId);
        Optional<Product> product = productDao.findById(ProductId);
        if(product.get().getPrice() > customer.get().getAmountOfMoney()) {
            throw new RuntimeException("Not enough money");
        }

        customer.get().setAmountOfMoney(customer.get().getAmountOfMoney() - product.get().getPrice());

        purchaseDao.save(new Purchase(CustomerId,ProductId));
    }
}
