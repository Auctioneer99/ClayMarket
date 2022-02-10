package com.example.clayMarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class ClayMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClayMarketApplication.class, args);
    }
}
