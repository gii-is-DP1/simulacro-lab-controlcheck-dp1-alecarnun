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

    /*public List<Product> getProductsCheaperThan(double price) {
        return productRepo.findByPriceLessThan(price);
    }*/

    public ProductType getProductType(String name) {
        //List<ProductType> listTypes = productRepo.findAllProductTypes();
        //return listTypes.stream().(t->t.getName().equals(name));
        return productRepo.findProductTypeByName(name);
    }

    @Transactional
	public void save(Product product) throws DataAccessException {
		//creating product
		productRepo.save(product);		
        
		
	}

    
}
