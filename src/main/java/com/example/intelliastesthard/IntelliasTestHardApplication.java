package com.example.intelliastesthard;

import com.example.intelliastesthard.entity.Customer;
import com.example.intelliastesthard.servce.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class IntelliasTestHardApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntelliasTestHardApplication.class, args);

    }

}
