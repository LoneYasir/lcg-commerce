package com.lcg.backend.service;

import com.lcg.backend.entity.Product;
import com.lcg.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {

        Product existingProduct = productRepository.findById(id).orElse(null);

        if (existingProduct == null) {
            return null;
        }

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setCategory(updatedProduct.getCategory());
        existingProduct.setBrand(updatedProduct.getBrand());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setDiscountPrice(updatedProduct.getDiscountPrice());
        existingProduct.setStock(updatedProduct.getStock());
        existingProduct.setImageUrl(updatedProduct.getImageUrl());
        existingProduct.setColor(updatedProduct.getColor());
        existingProduct.setSize(updatedProduct.getSize());
        existingProduct.setMaterial(updatedProduct.getMaterial());
        existingProduct.setIsFeatured(updatedProduct.getIsFeatured());

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}