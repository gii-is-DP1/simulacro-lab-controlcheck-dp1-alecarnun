
package org.springframework.samples.petclinic.product;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class ProductValidator implements Validator {

	private static final String REQUIRED = "required";

	@Override
	public void validate(Object obj, Errors errors) {
		Product p = (Product) obj;
		String name = p.getName();
		// name validation
		if (!StringUtils.hasLength(name) || name.length()>50 || name.length()<3) {
			errors.rejectValue("name", REQUIRED+" and between 3 and 50 characters", REQUIRED+" and between 3 and 50 character");
		}

		// type validation
		if (p.getProductType() == null) {
			errors.rejectValue("product_type", REQUIRED, REQUIRED);
		}

		// birth date validation
		if ( p.getPrice()<0) {
			errors.rejectValue("price", REQUIRED, REQUIRED);
		}
	}

	
	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

}
