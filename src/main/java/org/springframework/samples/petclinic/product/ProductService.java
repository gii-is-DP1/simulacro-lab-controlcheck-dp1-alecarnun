package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

    @Autowired
    ProductRepository productRepo;
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productRepo.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return productRepo.findProductType(typeName);
    }

    public Product save(Product p){
        return null;       
    }

    
}
