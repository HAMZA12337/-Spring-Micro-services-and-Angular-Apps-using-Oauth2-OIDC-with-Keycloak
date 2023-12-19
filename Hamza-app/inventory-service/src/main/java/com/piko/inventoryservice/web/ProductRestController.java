package com.piko.inventoryservice.web;


import com.piko.inventoryservice.entities.Product;
import com.piko.inventoryservice.repository.ProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {

private ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    @GetMapping("/products")
    @PreAuthorize("hasAuthority('ADMIN')")
public List<Product> products(){

return productRepository.findAll();}













}
