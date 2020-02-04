
package com.hexaware.MLP192.model;
/**
 * Orders class used to display orders information.
 * @author priyadharshini
 */
public class Orders {
/**
 * cusId to store cusid.
 */
  private String cusId;
  /**
 * ordId to store ordId.
 */
  private String ordId;
  /**
 * ordDate to store ordDate.
 */
  private java.util.Date ordDate;
  /**
 * ordItemSel to store ordItemSel.
 */
  private String ordItemSel;
/**
 *@param argcusId to initialize customer id
 *@param argordId to initialize order id
 *@param argordDate to initialize order date
 *@param argItemSel to initialize order item sel

 * used to get details through constructor.
 */
  public Orders(final String argCusId, final String argOrdId, final java.util.Date argOrdDate,
      final String argOrdItemSel) {
    this.cusId = argCusId;
    this.ordId = argOrdId;
    this.ordDate = argOrdDate;
    this.ordItemSel = argOrdItemSel;
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
if (java.util.Objects.equals(cusId, orders.cusId) || java.util.Objects.equals(ordId, orders.ordId) ||
java.util.Objects.equals(ordDate, orders.ordDate ) ||  java.util.Objects.equals(ordItemSel, orders.ordItemSel)) {
  return true;
}
return false;
}
@Override
public final int hashCode() {
return java.util.Objects.hash(cusId, ordId, ordDate, ordItemSel);
}

/**
 * @return this cusId,ordId,ordDate,ordTime,ordItemSel.
 */
public final String getcusId() {
return cusId;
}
/**
 * @return this ordID.
 */

public final String getordId() {
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

public final String ordItemSel() {
  return ordItemSel;
}
/**
     * @param argCusId gets the customer id.
     */

public final void setCusId(final String argCusId) {
this.cusId =  argCusId;
}
/**
     * @param argOrdId gets the order id.
     */
public final void setOrdId(final String argOrdId) {

this.ordId = argOrdId;
}
/**
     * @param argOrdDate gets the order date.
     */
public final void setOrdDate(final java.util.Date OrdDate) {
this.ordDate = OrdDate;
}
/**
     * @param argOrdItemSel gets the order Item Sel.
     */
public final void setOrdItemSel(final String argOrdItemSel) {
this.ordItemSel =  argOrdItemSel;
}



