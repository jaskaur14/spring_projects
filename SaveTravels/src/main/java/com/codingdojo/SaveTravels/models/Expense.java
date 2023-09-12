package com.codingdojo.SaveTravels.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="expenses")
public class Expense {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @NotBlank
    @Size(min = 1, max = 200, message="Name must not be blank")
    private String name;
    
    @NotBlank
    @Size(min = 1, max = 200, message="Vendor must not be blank")
    private String vendor;

    @NotNull(message="Amount must not be blank")
    @Min(value=0,message="Amount must be greater than zero")
    private Double amount;
    
    @NotBlank
    @Size(min = 1, max = 200, message="Description must not be blank")
    private String description;
    
    public Expense() {}
    
//    getters
    public Long getId() {
    	return id;
    }
    
    public String getName() {
    	return name;
    }
    
    public String getVendor() {
    	return vendor;
    }
    
    public Double getAmount() {
    	return amount;
    }
    
    public String getDescription() {
    	return description;
    }
    
//    setters
    public void setId(Long id) {
    	this.id = id;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setVendor(String vendor) {
    	this.vendor = vendor;
    }
    
    public void setAmount(Double amount) {
    	this.amount = amount;
    }
    
    public void setDescription(String description) {
    	this.description = description;
    }
}
    
