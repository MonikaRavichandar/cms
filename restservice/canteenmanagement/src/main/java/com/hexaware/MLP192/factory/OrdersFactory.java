
package com.hexaware.MLP192.factory;

import com.hexaware.MLP192.persistence.OrdersDAO;
import com.hexaware.MLP192.persistence.DbConnection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
  /**
   *
   * @param cusId customer id
   * @param ordItemSel items selected
   * @param ordQty order quantity
   * @param ordDate order Date
   * @param ordStatus order status
   * @param ordCost order cost
   * @return int
   */
  public static int insertingorders(final int cusId, final String ordItemSel, final String ordDate,
       final int ordQty, final String ordStatus, final float ordCost) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
    Date od = setDate(new Date());
    try {
      od = sdf.parse(ordDate);
    } catch (ParseException e) {
      System.out.println("Enter valid Date");
    }
    int i = dao().insertorders(cusId, ordItemSel, ordQty, od, ordStatus, ordCost);
    return i;
  }
  private static Date setDate(final Date ordDate) {
    return ordDate;
  }
     /**
   *
   * @param ordId customer id
   * @param ordItemSel items selected
   * @return NN
   */
  public static int updatingORDERS(final String ordItemSel, final int  ordId) {
    int j = dao().updateORDERS(ordItemSel, ordId);
    return j;
  }
     /**
   *
   * @param ordId customer id
   * @return hh
   */
  public static int deletingORDERS(final int ordId) {
    int k = dao().deleteORDERS(ordId);
    return k;
  }
   /**
   * @param ordStatus ordStatus
   * @param cusId id
   * @return the array of customer object.
   */
  public static int updateOrdStatus(final int cusId, final String ordStatus) {
    int order = dao().updateOrStatus(cusId, ordStatus);
    return order;
  }
   /**
   * Call the data base connection.
   * @param ordId for order id.
   * @return Orders
   */
  public static Orders validateOrder(final int ordId) {
    Orders v = dao().validateOrders(ordId);
    return v;
  }
   /**
   * Call the data base connection.
   * @param ordId for order id.
   * @return Orders
   */
  public static Orders getOrderDetails(final int ordId) {
    Orders od = dao().getOrderDetails(ordId);
    return od;
  }
}
