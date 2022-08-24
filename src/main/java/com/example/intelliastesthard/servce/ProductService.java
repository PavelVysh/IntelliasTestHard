package com.example.intelliastesthard.servce;

import com.example.intelliastesthard.dao.CustomerDao;
import com.example.intelliastesthard.dao.ProductDao;
import com.example.intelliastesthard.entity.Customer;
import com.example.intelliastesthard.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

@Service
public class ProductService {

    private ProductDao productDao;
    private EntityManager entityManager;

    @Autowired
    public ProductService(ProductDao productCustomerDao, EntityManager entityManager) {
        this.productDao = productCustomerDao;
        this.entityManager = entityManager;
    }

    public void saveProduct(Product product) {
        product.setId(0);
        productDao.save(product);
    }

    public List<Product> findAllProducts() {
        return productDao.findAll();
    }

    public Product findById(int id) {

        Optional<Product> product = productDao.findById(id);
        return product.get();
    }
    public List<Product> findAll() {

        return productDao.findAll();
    }

    public Set<Product> productsByCustomer(int customerId) {
        Query query = entityManager.createQuery("From Product");
        List<Product> products = query.getResultList();
        Set<Product> productsByCustomer = new HashSet<>();

        for(Product product : products) {
            List<Customer> customers = product.getCustomerList();
            for (Customer customer : customers) {
                if (customer.getId() == customerId) {
                    productsByCustomer.add(product);
                }
            }
        }
        return productsByCustomer;
    }
}
