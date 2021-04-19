/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.momentum.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author PeeGee
 */
@Entity
@Table(name = "TBL_PRODUCT")
@NamedQuery(name=Product.GET_ALL_PRODUCT,query="select p from Product p")
public class Product implements Serializable {
    
    public static final String GET_ALL_PRODUCT = "Product.getAllProducts";
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="Product_ID")        
    private Long productID;
    
    @NotEmpty(message="Product must be entered")
    @Size(max = 6, message = "Name must have atleast 6 charaters")
    private String productCode;
    
    @NotEmpty(message="Product must be entered")
    @Size(max = 25, message = "Name must have atleast 5 charaters")
    private String productName;
    
    @DecimalMin(value="1",message="Points must be atleast 1")
    @DecimalMax(value="1000000",message="Points must be atmost 1 Million")
    int costPoints;

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getCostPoints() {
        return costPoints;
    }

    public void setCostPoints(int costPoints) {
        this.costPoints = costPoints;
    }
    
    
}
