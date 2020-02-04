
package com.hexaware.MLP192.factory;

import com.hexaware.MLP192.persistence.OrdersDAO;
import com.hexaware.MLP192.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP192.model.Orders;
/**
 * OrdersFactory class used to fetch menu data from database.
 * @author priyadharshini
 */
public class OrdersFactory {
  /**
   *  Protected constructor.
   */
  protected OrdersFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OrdersDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrdersDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of Orders object.
   */
  public static Orders[] showOrders() {
    List<Orders> orders = dao().showOrder();
    return orders.toArray(new Orders[orders.size()]);
  }
}
