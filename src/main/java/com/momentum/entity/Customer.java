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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

/**
 *
 * @author PeeGee
 */
@Entity(name="TBL_CUSTOMER")
public class Customer implements Serializable{
       
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name="CUST_ID")        
    private Long customerID;
    
    @Size(max = 40, message = "Name must have atleast 40 charaters")
    @Column(name="CUST_NAME") 
    private String name;

    @DecimalMin(value="1",message="Points must be atleast 1")
    @DecimalMax(value="1000000",message="Points must be atmost 1 Million")
    @Column(name="TOTAL_POINTS") 
    int totalPoints;
    
    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
   
}
