package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    @Autowired

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findById(int theId) {
        Long theIdl=(long)theId;
        Optional<Product> result = productRepository.findById(theIdl);

        Product theProduct = null;

        if (result.isPresent()) {
            theProduct = result.get();
        }
        else {
            // we didn't find the product id
            throw new RuntimeException("Did not find part id - " + theId);
        }

        return theProduct;
    }

    @Override
    public void save(Product theProduct) {
        productRepository.save(theProduct);

    }

    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        productRepository.deleteById(theIdl);
    }
    public List<Product> listAll(String keyword){
        if(keyword !=null){
            return productRepository.search(keyword);
        }
        return (List<Product>) productRepository.findAll();
    }
    // Decrement Inventory
    @Override
    public boolean decrementInventory(Long productID) {
        Optional<Product> optionalProduct = productRepository.findById(productID);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            int currentInventory = product.getInv();
            if (currentInventory > 0) { // Ensure inventory is not already zero
                int updatedInventory = currentInventory - 1;
                product.setInv(updatedInventory);
                productRepository.save(product);
                return true; // Return true indicating successful inventory decrement
            }
        }
        return false; // Return false if product not found or inventory already zero
    }
}
