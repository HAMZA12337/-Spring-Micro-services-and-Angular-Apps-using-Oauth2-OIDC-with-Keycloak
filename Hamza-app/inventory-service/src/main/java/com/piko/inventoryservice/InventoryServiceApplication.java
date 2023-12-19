package com.piko.inventoryservice;

import com.piko.inventoryservice.entities.Product;
import com.piko.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args ->{

            productRepository.save(Product.builder()

                            .id(UUID.randomUUID().toString())
                            .name("Phone")
                            .quantity(12)
                            .price(1222)
                             .build());
            productRepository.save(Product.builder()

                    .id(UUID.randomUUID().toString())
                    .name("Laptop")
                    .quantity(11)
                    .price(1222)
                    .build());
            productRepository.save(Product.builder()

                    .id(UUID.randomUUID().toString())
                    .name("Watch")
                    .quantity(2)
                    .price(1222)
                    .build());


        };
    }


}
