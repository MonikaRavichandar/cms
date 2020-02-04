
package com.hexaware.MLP192.model;

import java.sql.Date;
import java.util.Objects;

/**
 * Menu class used to display customer information.
 * @author hexware
 */
public class Customer {
    /**
     * cusId to store customerId.
     */
  private String cusId;
  private String cusPwd;
  private String cusName;
  private Date cusDob;
  private String cusPh;
  private String cusAdd;

  /**
   * Default Constructor.
   */
  public Customer() {

  }
/**
 * @param argCusId to initialize customer Id.
 * @param argCusPwd to initialize customer password.
 * @param  argCusName to initialize customer id.
 * @param argCusDob to initialize customer dateof birth.
 * @param argCusPh to initialize customer phone.
 * @param argCusAdd to initialize customer address.
 * used to get details through constructor.
 */
  public Customer(final String argCusId, final String argCusPwd, final String argCusName,
      final Date argCusDob, final String argCusPh, final String argCusAdd) {
    this.cusId = argCusId;
    this.cusPwd = argCusPwd;
    this.cusName = argCusName;
    this.cusDob = argCusDob;
    this.cusPh = argCusPh;
    this.cusAdd = argCusAdd;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Customer cus = (Customer) obj;
    if (Objects.equals(cusId, cus.cusId)
         || Objects.equals(cusPwd, cus.cusPwd)
         || Objects.equals(cusName, cus.cusName)
         || Objects.equals(cusDob, cus.cusDob)
         || Objects.equals(cusPh, cus.cusPh)
         || Objects.equals(cusAdd, cus.cusAdd)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(cusId, cusPwd, cusName, cusDob, cusPh, cusAdd);
  }
    /**
     * @return this customer ID.
     */
  public final String getcusId() {
    return cusId;
  }
  /**
     * @return this customer ID.
     */

  public final String getcusPwd() {
    return cusPwd;
  }
  /**
     * @return this customer ID.
     */
  public final String getcusName() {
    return cusName;
  }
  /**
     * @return this customer ID.
     */
  public final Date getcusDob() {
    return cusDob;
  }
  /**
     * @return this customer Dob.
     */
  public final String getcusPh() {
    return cusPh;
  } /**
     * @return this customer PH.
     */
  public final String getcusAdd() {
    return cusAdd;
  }
  /**
     * @return this customer Add.
     */
    /**
     * @param argCusId gets the customer Id.
     */
  public final void setcusId(final String argCusId) {
    this.cusId = argCusId;
  }
  /**
     * @param argCusPwd gets the customer Id.
     */
  public final void setcusPwd(final String argCusPwd) {
    this.cusPwd = argCusPwd;
  }
  /**
     * @param argCusName gets the customer Name.
     */
  public final void setcusName(final String argCusName) {
    this.cusName = argCusName;
  }
  /**
     * @param argCusDob gets the customer Dob.
     */
  public final void setcusDob(final String argCusDob) {
    this.cusName = argCusDob;
  }
  /**
     * @param argCusPh gets the customer Ph.
     */
  public final void setcusPh(final String argCusPh) {
    this.cusPh = argCusPh;
  }
  /**
     * @param argCusAdd gets the customer Add.
     */
  public final void setcusAdd(final String argCusAdd) {
    this.cusAdd = argCusAdd;
  }

}
