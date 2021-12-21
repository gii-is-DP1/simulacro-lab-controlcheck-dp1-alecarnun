package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

    @Autowired
    ProductRepository productRepo;


    @Override
    public String print(ProductType object, Locale locale) {
        
         List<ProductType> allProductTypes = productRepo.findAllProductTypes();
         if(allProductTypes.contains(object)){
             return object.toString();
         }
         return null;
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        
            return productRepo.findProductType(text);
    }
    
}
