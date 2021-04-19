/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academy.learnprogramming.service;

import com.momentum.entity.Customer;
import com.momentum.entity.Product;
import com.momentum.services.DatabaseSetup;
import com.momentum.services.PersistenceService;
import com.momentum.services.QueryService;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author PeeGee
 */


public class DatabaseSetupTest {

    DatabaseSetup dbTest;
    
    @Test
    public void testCreateCustomers(){
        
        List<Customer> listOfCustomers=dbTest.createCustomers();
        assertEquals(listOfCustomers.size(),5);
    }
    
    @Test
    public void testCreateProducts(){
        
        List<Product> listOfProducts=dbTest.createProducts();
        assertEquals(listOfProducts.size(),5);
    }
   
}
