package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface ProductRepository extends CrudRepository<Product,Integer>{
    List<Product> findAll();
    @Query("SELECT pType FROM ProductType pType")
    List<ProductType> findAllProductTypes() throws DataAccessException;
    
    Optional<Product> findById(int id);

    @Query("SELECT DISTINCT p FROM Product p WHERE p.name like name")
    Product findByName(@Param("name") String name) throws DataAccessException;
 
    @Query("SELECT DISTINCT pType FROM ProductType pType WHERE pType.name = ?1")
    ProductType findProductTypeByName(String name) throws DataAccessException;
    
    @Query("SELECT p FROM Product p WHERE p.price < ?1")
    List<Product> findByPriceLessThan(double price);

    Product save(Product p) throws DataAccessException;
}
