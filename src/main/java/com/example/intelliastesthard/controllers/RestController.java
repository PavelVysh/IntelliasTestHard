package com.example.intelliastesthard.controllers;


import com.example.intelliastesthard.entity.Customer;
import com.example.intelliastesthard.entity.Product;
import com.example.intelliastesthard.servce.CustomerService;
import com.example.intelliastesthard.servce.ProductService;
import com.example.intelliastesthard.servce.PurchaseService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")

public class RestController {

    private final CustomerService customerService;
    private final ProductService productService;
    private final PurchaseService purchaseService;


    @Autowired
    public RestController(CustomerService customerService,
                          ProductService productDao, PurchaseService purchaseService) {
        this.customerService = customerService;
        this.productService = productDao;
        this.purchaseService = purchaseService;
    }

    @PostMapping("/createCustomer")
    public Customer createCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }
    @PostMapping("/createProduct")
    public Product createUser(@RequestBody Product product) {
        product.setId(0);
        productService.saveProduct(product);
        return product;
    }

    @RequestMapping("/listCustomers")
    public List<Customer> listCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/listCustomers/{id}")
    public Customer findUserById(@PathVariable int id) {
        return customerService.findById(id);
    }

    @GetMapping("/listProducts")
    public List<Product> listProducts() {
        return productService.findAll();
    }

    @GetMapping("/listProducts/{id}")
    public Product findProductById(@PathVariable int id) {
        return productService.findById(id);
    }

    @RequestMapping("/makePurchase/{customerId}/{productId}")
    public String makePurchase(@PathVariable int customerId, @PathVariable int productId) {
        purchaseService.makePurchase(customerId,productId);
        return "Purchase was successful";
    }
    @GetMapping("/listByProduct/{productId}")
    public Set<Customer> listByProduct(@PathVariable int productId) {
        return customerService.findByProduct(productId);
    }
    @GetMapping("/listByCustomers/{customerId}")
    public Set<Product> listByCustomer(@PathVariable int customerId) {
        return productService.productsByCustomer(customerId);
    }
}
