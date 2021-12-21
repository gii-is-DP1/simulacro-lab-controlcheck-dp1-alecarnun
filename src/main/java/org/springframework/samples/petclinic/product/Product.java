package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="product")
public class Product {

    @Id
    private Integer id;
    
    @NotEmpty
    @Size(min=3,max=50)
    private String name;

    @NotEmpty
    @PositiveOrZero
    private double price;

    @ManyToOne
    @JoinColumn(name = "productType")
    private ProductType productType;

    
    
}
