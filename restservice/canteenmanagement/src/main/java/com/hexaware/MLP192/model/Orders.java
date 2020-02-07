
package com.hexaware.MLP192.model;
/**
 * Orders class used to display orders information.
 * @author priyadharshini-hexware
 */
public class Orders {
/**
 * cusId to store cusid.
 */
  private int  cusId;
  private int  ordId;
  private java.util.Date ordDate;
  private String ordItemSel;
  private int ordQty;
  private String ordStatus;
/**
 *@param argCusId to initialize customer id.
 *@param argOrdId to initialize order id
 *@param argOrdDate to initialize order date
 *@param argOrdItemSel to initialize order item sel
 *@param argOrdQty to initialize order quantity
 *@param argOrdStatus to initialize order quantity

 * used to get details through constructor.
 */
  public Orders(final int argCusId, final int argOrdId, final java.util.Date argOrdDate,
      final String argOrdItemSel, final int argOrdQty, final String argOrdStatus) {
    this.cusId = argCusId;
    this.ordId = argOrdId;
    this.ordDate = argOrdDate;
    this.ordItemSel = argOrdItemSel;
    this.ordQty = argOrdQty;
    this.ordStatus = argOrdStatus;
  }
  @Override
public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Orders orders = (Orders) obj;
    if (java.util.Objects.equals(cusId, orders.cusId) || java.util.Objects.equals(ordId, orders.ordId)
         || java.util.Objects.equals(ordDate, orders.ordDate)
         || java.util.Objects.equals(ordItemSel, orders.ordItemSel)
         ||  java.util.Objects.equals(ordQty, orders.ordQty) || java.util.Objects.equals(ordStatus, orders.ordStatus)) {
      return true;
    }
    return false;
  }
  @Override
public final int hashCode() {
    return java.util.Objects.hash(cusId, ordId, ordDate, ordItemSel, ordQty, ordStatus);
  }

/**
 * @return this cusId,ordId,ordDate,ordTime,ordItemSel.
 */
  public final int getcusId() {
    return cusId;
  }
/**
 * @return this ordID.
 */

  public final int getordId() {
    return ordId;
  }
/**
 * @return this ordDate.
 */
  public final java.util.Date getordDate() {
    return ordDate;
  }
/**
 * @return this ordItemSel.
 */

  public final String getordItemSel() {
    return ordItemSel;
  }
  /**
 * @return this ordItemSel.
 */

  public final String getordStatus() {
    return ordStatus;
  }
  /**
 * @return this ord qty.
 */

  public final int  getordQty() {
    return ordQty;
  }
/**
     * @param argCusId gets the customer id.
     */

  public final void setCusId(final int argCusId) {
    this.cusId =  argCusId;
  }
/**
     * @param argOrdId gets the order id.
     */
  public final void setOrdId(final int  argOrdId) {

    this.ordId = argOrdId;
  }
/**
     *@param argOrdDate gets the order date.
     */
  public final void setOrdDate(final java.util.Date argOrdDate) {
    this.ordDate = argOrdDate;
  }
/**
     * @param argOrdItemSel gets the order Item Sel.
     */
  public final void setOrdItemSel(final String argOrdItemSel) {
    this.ordItemSel = argOrdItemSel;
  }
  /**
     * @param argOrdQty gets the order Item Sel.
     */
  public final void setOrdQty(final int argOrdQty) {
    this.ordQty = argOrdQty;
  }
  /**
     * @param argOrdStatus gets the order Item Sel.
     */
  public final void setOrdStatus(final String argOrdStatus) {
    this.ordStatus = argOrdStatus;
  }
}


