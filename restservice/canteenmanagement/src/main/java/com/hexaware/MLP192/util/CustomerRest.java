
package com.hexaware.MLP192.util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP192.factory.CustomerFactory;
import com.hexaware.MLP192.model.Customer;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/customer")
public class CustomerRest {
  /**
   * Returns Customer details.
   * @return the customer details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Customer[] listzCustomer() {
    final  Customer[] customer =  CustomerFactory.showCustomer();
    return customer;
  }
}
