package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET all products with pagination
    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page) {
        return productService.getAllProducts(PageRequest.of(page, 10));
    }

    // GET product by ID, including category details
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // POST create a new product for a specific category
    @PostMapping("/category/{categoryId}")
    public Product createProduct(@PathVariable Long categoryId, @RequestBody Product product) {
        return productService.createProduct(categoryId, product);
    }

    // PUT update a product by ID
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    // DELETE product by ID
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
