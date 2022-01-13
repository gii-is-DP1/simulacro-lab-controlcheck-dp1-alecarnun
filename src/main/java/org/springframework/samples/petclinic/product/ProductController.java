package org.springframework.samples.petclinic.product;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService){
	this.productService = productService;
	}

	@ModelAttribute("productTypes")
	public List<ProductType> loadProductTypes() {
	List<ProductType> pTypes = this.productService.getAllProductTypes();
	return pTypes;
	}


	@GetMapping(value = "/product/create")
	public String initNewProductForm(ModelMap model) {
	Product product = new Product();
	model.put("product", product);
	return "products/createOrUpdateProductForm";
	}

	@PostMapping(value = "/product/create")
	public String processNewProductForm(@Valid Product product, BindingResult result) {
	if (result.hasErrors()) {
		return "products/createOrUpdateProductForm";
	}
	else {
		this.productService.save(product);
		return "welcome";
	}
	}
      
    
}
