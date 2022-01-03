package org.springframework.samples.petclinic.product;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ProductController {

	private static final String VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";

	private final ProductService productService;
    

	@Autowired
	public ProductController(ProductService pService) {
		this.productService = pService;
	}

	@ModelAttribute("product_types")
	public Collection<ProductType> populateProductTypes() {
		return this.productService.getAllProductTypes();
	}

	@InitBinder("pet")
	public void initPetBinder(WebDataBinder dataBinder) {
        		dataBinder.setValidator(new ProductValidator());
	}

	@GetMapping(value = "/product/create")
	public String initCreationForm(ModelMap model) {
		Product product = new Product();
		
		model.put("product", product);
		return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/product/create")
	public String processCreationForm(@Valid Product product, BindingResult result, ModelMap model) {		
		if (result.hasErrors()) {
			model.put("product", product);
			return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
		}
		else {
                    try{
                    	//owner.addPet(pet);
                    	this.productService.saveProduct(product);
                    }catch(Exception ex){
                        //result.rejectValue("name", "duplicate", "already exists");
                        return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
                    }
                    return "redirect:/product/{productId}";
		}
	}

	
    /**
     *
     * @param pet
     * @param result
     * @param petId
     * @param model
     * @param owner
     * @param model
     * @return
     */
      
    
}
