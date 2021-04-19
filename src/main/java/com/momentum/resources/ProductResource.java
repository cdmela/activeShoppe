/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.momentum.resources;

import com.momentum.entity.Product;
import com.momentum.services.QueryService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
@Path("product")
@Consumes("application/json")
@Produces("application/json")
public class ProductResource {
    
   @Inject 
   private QueryService queryService;
   
   /**Injecting Metrics
   @Inject
   @Metric(name="total_number_getProducts_call",absolute=true)        
   Counter getProductsCounter;
   
   @Inject
   @Metric(name="total_number_getProductByID_call",absolute=true)
   Counter getProductByIDCounter; **/  
 
   @GET
   @Path("products")
   public List<Product> getProducts(){
     //getProductsCounter.inc();
     return queryService.getAllProducts();
   }
   @GET
   @Path("product/{id}")
   public Response getProductByID(@PathParam("id") Long prodID){
      // getProductByIDCounter.inc();
       Product product=queryService.getProductByID(prodID);
      
       return Response.ok(product).status(Response.Status.OK).build();
   }
      
}
