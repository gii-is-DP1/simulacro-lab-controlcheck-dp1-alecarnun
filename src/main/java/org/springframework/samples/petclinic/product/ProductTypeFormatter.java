package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

    private final ProductService pService;

	@Autowired
	public ProductTypeFormatter(ProductService productService) {
		this.pService = productService;
	}

	@Override
	public String print(ProductType productType, Locale locale) {
		return productType.getName();
	}

	@Override
	public ProductType parse(String text, Locale locale) throws ParseException {
		Collection<ProductType> findProductTypes = this.pService.getAllProductTypes();
		for (ProductType type : findProductTypes) {
			if (type.getName().equals(text)) {
				return type;
			}
		}
		throw new ParseException("type not found: " + text, 0);
	}
    
}
