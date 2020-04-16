package com.apiproject.tect.controllers;

import com.apiproject.tect.entities.Product;
import com.apiproject.tect.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Iterable<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.find(id);
    }

    @PostMapping("/search")
    public List<Product> searchProducts(@RequestBody String product) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Integer> map = mapper.readValue(product, Map.class);
        return productService.search(map.get("min"), map.get("max"));
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.delete(id);
    }
}
