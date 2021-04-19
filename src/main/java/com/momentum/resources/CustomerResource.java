/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.momentum.resources;

import com.momentum.entity.Customer;
import com.momentum.entity.Product;
import com.momentum.services.PersistenceService;
import com.momentum.services.QueryService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Metric;

/**
 *
 * @author PeeGee
 */
@Path("customer")
@Consumes("application/json")
@Produces("application/json")
public class CustomerResource {
    
    @Inject
    private QueryService queryServ;
    @Inject
    private PersistenceService persistenceServ;
    
   /**Injecting Metrics
   @Inject
   @Metric(name="total_number_getCustomer_call",absolute=true)
   Counter getCustomersCounter;
   @Inject
   @Metric(name="total_number_purchase_call",absolute=true)
   Counter purchaseCounter;  */ 
 
    @GET
    @Path("customer/{id}")
    public Response getCustomer(@PathParam("id")Long custID){
       // getCustomersCounter.inc();
        Customer cust=queryServ.getCustomerByID(custID);       
        return Response.ok(cust).status(Response.Status.OK).build();
    }
    @PUT
    @Path("purchase/{custId}/{prodId}")
    public Response purchase(@PathParam("custId")Long custID,@PathParam("prodId")Long prodID){
       //purchaseCounter.inc();
       Customer cust=queryServ.getCustomerByID(custID);
       Product prod=queryServ.getProductByID(prodID);
       if(prodID.toString()==null){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("No product ID provided").build();
       }else if(prod==null){        
             return Response.status(Response.Status.NOT_FOUND)
                    .entity("Product does not exist").build();
        }else if(cust==null){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Customer does not exist").build();
        }
        int custPoints= cust.getTotalPoints();
        int prodPoints=prod.getCostPoints();
        
        if(custPoints>=prodPoints){
            int newPoints=custPoints-prodPoints;
            cust.setTotalPoints(newPoints);
            persistenceServ.updateCustomer(cust);
            return Response.ok(cust).status(Response.Status.OK).build();
        }else{
            String message="Customer has insufficient points";
            return Response.ok(Response.Status.NO_CONTENT).entity(message).build();
        }            
        
    }   
    
}
