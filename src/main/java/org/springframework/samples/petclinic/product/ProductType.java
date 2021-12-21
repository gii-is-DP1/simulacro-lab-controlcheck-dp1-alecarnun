package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="productType")
public class ProductType {
    @Id
    private Integer id;

    @Column(unique = true)
    @NotEmpty
    @Size(min=3,max=50)
    private String name;
}
