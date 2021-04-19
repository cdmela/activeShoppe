/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.momentum.services;

import com.momentum.entity.Customer;
import com.momentum.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author PeeGee
 */
@Singleton
@Startup
public class DatabaseSetup {
    
   @Inject 
   private PersistenceService persistenceServ;
    @PostConstruct
    private void init(){
        List<Customer> customers=createCustomers();
        List<Product> products=createProducts();
        for(Customer cust:customers){
            persistenceServ.saveCustomer(cust);
        }
        for(Product prod:products){
            persistenceServ.saveProduct(prod);
        }
    }
    /**
     *  The method to create pre-loaded customer to DB     
     */
    public static List<Customer> createCustomers(){
        
        List<Customer> cutomers=new ArrayList<>();
        
        Customer cust1=new Customer();
        cust1.setName("Phathu Sidimela");
        cust1.setTotalPoints(4500);
        cutomers.add(cust1);
        
        Customer cust2=new Customer();
        cust2.setName("Godfrey PeeGee");
        cust2.setTotalPoints(9500);
        cutomers.add(cust2);
        
        Customer cust3=new Customer();
        cust3.setName("John Gates");
        cust3.setTotalPoints(10000);
         cutomers.add(cust3);
         
        Customer cust4=new Customer();
        cust4.setName("Rich Man");
        cust4.setTotalPoints(1000000);
        cutomers.add(cust4);
       
        Customer cust5=new Customer();
        cust5.setName("Mr Fine");
        cust5.setTotalPoints(500000);
        cutomers.add(cust5);

        return cutomers;
    }
     /**
     * The method to create pre-loaded Customer to DB     
     */
    public static List<Product> createProducts(){
        
        List<Product> products=new ArrayList<>();
        
        Product prod1=new Product();
        prod1.setProductCode("PAN123");
        prod1.setProductName("Pants");
        prod1.setCostPoints(8500);
        products.add(prod1);
        
        Product prod2=new Product();
        prod2.setProductCode("VES200");
        prod2.setProductName("Vest");
        prod2.setCostPoints(3500);
        products.add(prod2);
        
        Product prod3=new Product();
        prod3.setProductCode("CAP600");
        prod3.setProductName("Cap");
        prod3.setCostPoints(1600);
        products.add(prod3);
        
        Product prod4=new Product();
        prod4.setProductCode("SNE800");
        prod4.setProductName("Sneakers");
        prod4.setCostPoints(200000);
        products.add(prod4);
        
        Product prod5=new Product();
        prod5.setProductCode("BAL800");
        prod5.setProductName("Soccer Ball");
        prod5.setCostPoints(150000);
        products.add(prod5);
               
        return products;
    }
    
}
