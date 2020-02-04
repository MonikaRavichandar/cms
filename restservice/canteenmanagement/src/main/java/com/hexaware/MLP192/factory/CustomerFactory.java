package com.hexaware.MLP192.factory;

import com.hexaware.MLP192.persistence.CustomerDAO;
import com.hexaware.MLP192.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP192.model.Customer;
/**
 * CustomerFactory class used to fetch customer data from database.
 * @author hexware
 */
public class CustomerFactory {
  /**
   *  Protected constructor.
   */
  protected CustomerFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static CustomerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CustomerDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of customer object.
   */
  public static Customer[] showCustomer() {
    List<Customer> customer = dao().showCus();
    return customer.toArray(new Customer[customer.size()]);
  }
}
