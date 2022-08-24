package com.example.intelliastesthard.servce;

import com.example.intelliastesthard.dao.CustomerDao;

import com.example.intelliastesthard.entity.Customer;
import com.example.intelliastesthard.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerService {

    private CustomerDao customerDao;
    private EntityManager entityManager;


    @Autowired
    public CustomerService(CustomerDao customerDao, EntityManager entityManager) {
        this.customerDao = customerDao;
        this.entityManager = entityManager;
    }

    public void saveCustomer(Customer customer) {
        customer.setId(0);
        customerDao.save(customer);
    }
    public List<Customer> findAllCustomers() {

        return customerDao.findAll();
    }

    public Customer findById(int id) {

        return entityManager.find(Customer.class,id);
    }

    public Set<Customer> findByProduct(int productId) {
            Query query = entityManager.createQuery("From Customer");
        List<Customer> customers = query.getResultList();
        Set<Customer> customersWithProduct = new HashSet<>() {};

        for(Customer customer : customers) {
            List<Product> products = customer.getProducts();
            for (Product product : products) {
                if (product.getId() == productId) {
                    customersWithProduct.add(customer);
                }
            }
        }
        return customersWithProduct;
    }

}
