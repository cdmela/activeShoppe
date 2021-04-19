/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academy.learnprogramming.service;

import com.momentum.entity.Customer;
import com.momentum.entity.Product;
import com.momentum.services.QueryService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author PeeGee
 */
@RunWith(MockitoJUnitRunner.class)
public class QueryServiceTest {
    @Mock
    QueryService queryServ;
    
    Customer cust;
    @Before
    public void setUp(){
        cust=new Customer();
        cust.setName("James");
        cust.setTotalPoints(100);
    }
    
    public void testGetCustomerbyID(){
        
       Mockito.when(queryServ.getCustomerByID(new Long(10))).thenReturn(new Customer());
       Customer cust= queryServ.getCustomerByID(new Long(10));
       Assert.assertEquals(cust, new Customer());
    }
    
    @Test
    public void testCheckCustomerbyName(){
   
       Mockito.when(queryServ.getCustomerByID(new Long(10))).thenReturn(cust);
       Customer cust= queryServ.getCustomerByID(new Long(10));
       Assert.assertEquals(cust.getName(), cust.getName());
    }
    @Test
    public void testGetAllProducts(){
        Mockito.when(queryServ.getAllProducts()).thenReturn(new ArrayList<Product>());
        List prodList= queryServ.getAllProducts();
        Assert.assertEquals(prodList, new ArrayList<Product>());
    }
}
