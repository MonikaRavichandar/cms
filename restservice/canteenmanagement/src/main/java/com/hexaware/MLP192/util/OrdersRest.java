
package com.hexaware.MLP192.util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.MLP192.factory.OrdersFactory;
import com.hexaware.MLP192.model.Orders;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/order")
public class OrdersRest {
  /**
   * Returns vendor details.
   * @return the vendor details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Orders[] listOrder() {
    final Orders[] orders = OrdersFactory.showOrders();
    return orders;
  }
}
