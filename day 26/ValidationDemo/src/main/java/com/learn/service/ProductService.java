package com.learn.service;

import com.learn.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.learn.model.Product;


import java.util.Map;

@Service
public class ProductService {

    private static final Logger Logger = LoggerFactory.getLogger(ProductService.class);

    // Example in-memory product storage
    private Map<Long, Product> productRepo;

    public Product getProductById(Long id) throws ResourceNotFoundException {
        Logger.info("Fetching the product with id : {} ", id);

        if (!productRepo.containsKey(id)) {
            throw new ResourceNotFoundException("Product Not Found with this id :" + id);
        }
        return productRepo.get(id); // You are retrieving on the basis of key
    }

    // Constructor, setter, or initialization for productRepo needed in real app
}
