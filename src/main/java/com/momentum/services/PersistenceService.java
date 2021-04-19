/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.momentum.services;

import com.momentum.entity.Customer;
import com.momentum.entity.Product;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PeeGee
 */
@DataSourceDefinition(
        name = "java:app/ActiveShoppe/myDataSource",
        className = "org.apache.derby.jdbc.ClientDriver",
        url = "jdbc:derby://localhost:1527/activeshoppe",
        user = "appuser",
        password = "password")

@Stateless
public class PersistenceService {
    
    @PersistenceContext
    EntityManager em;
    
    public void saveCustomer(Customer cust){
        em.persist(cust);
    }
    
    public void updateCustomer(Customer cust){
        em.merge(cust);
    } 
   
    public void saveProduct(Product prod){
        em.persist(prod);
    }
    
}
