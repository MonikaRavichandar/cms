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
  /**
   * Call the data base connection.
   * @param venName insert VENNAME.
   * @return the array of Vendor object.
   */
  public static int addVendor(final String venName) {
    int i = dao().addingVendor(venName);
    return i;
  }
   /**
   * Call the data base connection.
   * @param venName to delete vendor name.
   * @return the array of Vendor object.
   */
  public static int deleteVendor(final String venName) {
    int j = dao().deletingVendor(venName);
    return j;
  }
   /**
   * Call the data base connection.
   * @param venStatus to update vendor status.
   * @return the array of Vendor object.
   *@param venId ll
   */

  public static int updateVendor(final String venStatus, final int venId) {
    int k = dao().updatingVendor(venStatus, venId);
    return k;
  }
   /**
   * Call the data base connection.
   * @param venName insert VENNAME.
   * @param venPwd insert VenPwd.
   * @param venPh insert VenPh.
   * @return the array of Vendor object.
   */
  public static int signupVendor(final String venName, final String venPwd, final String venPh) {
    int i = dao().signingVendor(venName, venPwd, venPh);
    return i;
  }
  /**
   * Call the data base connection.
   * @param venName insert VENNAME.
   * @param venPwd insert VenPwd.
   * @return the array of Vendor object.
   */
  public static Vendor loginVendor(final String venName, final String venPwd) {
    Vendor vendor = dao().loginingVendor(venName, venPwd);
    return vendor;
  }

}

