
package com.hexaware.MLP192.factory;

import com.hexaware.MLP192.persistence.VendorDAO;
import com.hexaware.MLP192.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP192.model.Vendor;
/**
 * VendorFactory class used to fetch Vendor data from database.
 * @author hexware
 */
public class VendorFactory {
  /**
   *  Protected constructor.
   */
  protected VendorFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of Vendor object.
   */
  public static Vendor[] showVendor() {
    List<Vendor> vendor = dao().showVend();
    return vendor.toArray(new Vendor[vendor.size()]);
  }
}
