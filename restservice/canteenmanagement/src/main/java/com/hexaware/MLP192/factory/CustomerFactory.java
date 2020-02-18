package com.hexaware.MLP192.factory;

import com.hexaware.MLP192.persistence.CustomerDAO;
import com.hexaware.MLP192.persistence.DbConnection;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
  /**
   * @param cusPwd  pwd
   * @param cusName name
   * @param cusDob  dob
   * @param cusPh   phone
   * @param cusAdd  add Call the data base connection.
   * @param cusWallet customer wallet
    * @return the array of customer object.
   */
  public static int insertCustomer(final String cusPwd, final String cusName, final String cusDob,
      final String cusPh, final String cusAdd, final float cusWallet) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date od = null;
    try {
      od = sdf.parse(cusDob);
    } catch (ParseException e) {
      System.out.println("Enter valid Date");
    }
    int i = dao().addingCustomer(cusName, cusPwd, od, cusPh, cusAdd, cusWallet);
    return i;
  }
  /**
   * @param cusName name.
   * @param cusPwd Pwd.
   * @return returning.
   */
  public static Customer loginCustomer(final String cusName, final String cusPwd) {
    Customer customer = dao().loginingCustomer(cusName, cusPwd);
    return customer;
  }

  /**
   * @param cusPh phone
   * @return the array of customer object.
   */
  public static int deleteCustomer(final String cusPh) {
    int j = dao().deletingCustomer(cusPh);
    return j;
  }
  /**
   * @param cusPh phone
   * @param cusId id
   * @return the array of customer object.
   */
  public static int updateCustomer(final String cusPh, final int cusId) {
    int k = dao().updatingCustomer(cusPh, cusId);
    return k;
  }
   /**
  * @param name id
  * @return  customer  bal.
  */
  public static Customer showCusWalletBalance(final int name) {
    Customer customer = dao().showCusWalBal(name);
    return customer;
  }
  /**
   * @param cusWallet wallet
   * @param cusId id
   * @return the array of customer object.
   */
  public static int  updateCustomerWalBal(final int cusId, final float cusWallet) {
    int customer = dao().updatingCustomerWal(cusId, cusWallet);
    return customer;
  }
   /**
  * @param cusId id
  * @return  customer  bal.
  */
  public static Customer viewCustomer(final int cusId) {
    Customer customer = dao().showCustomer(cusId);
    return customer;
  }
}




