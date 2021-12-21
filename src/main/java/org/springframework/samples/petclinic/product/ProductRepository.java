package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface ProductRepository extends CrudRepository<Product,Integer>{
    List<Product> findAll();
    @Query("SELECT * FROM ProductType")
    List<ProductType> findAllProductTypes();
    
    Optional<Product> findById(int id);
    Product findByName(String name);
    @Query("SELECT DISTINCT p FROM ProductType p WHERE p.name =: name")
    ProductType findProductType(@Param("name") String name);
    
    @Query("SELECT p FROM ProductType p WHERE p.price < price")
    List<Product> findByPriceLessThan(@Param("price") Double price);
    Product save(Product p);
}
