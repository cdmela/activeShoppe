/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.momentum.services;

import com.momentum.entity.Customer;
import com.momentum.entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PeeGee
 */
@Stateless
public class QueryService {
    @PersistenceContext
    EntityManager em;
    
    public Customer getCustomerByID(Long id){
        return em.find(Customer.class, id);
    } 
    
    public List<Product> getAllProducts(){
        return em.createNamedQuery(Product.GET_ALL_PRODUCT, Product.class).getResultList();
    }
    
    public Product getProductByID(Long id){
        return em.find(Product.class, id);
    }
    
    
}
