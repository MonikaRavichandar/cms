
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
   *@param ordDate mkk
   * @param ordItemSel gg
   * @param ordQty order quantity
   * @return NN
   */
  public static int insertingORDERS(final String ordDate, final String ordItemSel, final int ordQty) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date od = null;
    try {
      od = sdf.parse(ordDate);
    } catch (ParseException e) {
      System.out.println("Enter valid Date");
    }
    int i = dao().insertORDERS(od, ordItemSel, ordQty);
    return i;
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
}
