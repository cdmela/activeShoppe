/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academy.learnprogramming.service;

import com.momentum.entity.Customer;
import com.momentum.services.PersistenceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author PeeGee
 */
@RunWith(MockitoJUnitRunner.class)
public class PersistenceServiceTest {
    @Mock
    PersistenceService persistenceServ;
   
    Customer cust;
    @Before
    public void setUp(){
        cust=new Customer();
        cust.setName("James");
        cust.setTotalPoints(100);
    }
    
    @Test
    public void testSaveCustomer(){
        persistenceServ.saveCustomer(cust);
        verify(persistenceServ, times(1)).saveCustomer(cust);
    }
}
