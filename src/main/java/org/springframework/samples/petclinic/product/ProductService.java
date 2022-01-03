package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepo;

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productRepo.findByPriceLessThan(price);
    }

    public ProductType getProductType(String name) {
        return productRepo.findProductTypeByName(name);
    }

    public List<ProductType> getAllProductTypes(){
        return productRepo.findAllProductTypes();
    }

    /*@Transactional
	public void save(Product product) throws DataAccessException {
		//creating product
		productRepo.save(product);		
        
		
	}*/
    public Product save(Product p){
        return null;       
    }

    
}
