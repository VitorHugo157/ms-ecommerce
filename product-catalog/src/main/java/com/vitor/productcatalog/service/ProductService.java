package com.vitor.productcatalog.service;

import com.vitor.productcatalog.model.Product;
import com.vitor.productcatalog.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return verifyIfExists(id);
    }

    public void deleteById(Long id) {
        verifyIfExists(id);
        productRepository.deleteById(id);
    }

    private Product verifyIfExists(Long id) {
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
