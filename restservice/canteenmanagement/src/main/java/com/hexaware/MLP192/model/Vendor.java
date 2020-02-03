package com.hexaware.MLP192.model;
import java.util.Objects;

/**
 * Vendor class used to display vendor information.
 * @author monika-hexware
 */
public class Vendor {
/**
 * foodId to store venId.
   cusId to store cusId.
   venName to store venName.
   venStatus to store venStatus.
   venNo to store venNo.
 */
  private String venId;
  private String cusId ;
  private String venName;
  private String venStatus;
  private String venNo;
 

  /**
   * Default Constructor.
   */
  public Vendor() {

  }

  /**
  * @param argvenId, @param argcusId, @param argenvenName, @param argvenStatus, @param argvenNo to initialize venId, cusId, venName, venStatus, venNo.
  * used to get details through constructor.
   */
  public Vendor(final String argVenId, final String argCusId, final String argVenName, final String argVenStatus,final String argVenNo){
    this.venId = argVenId;
    this.cusId = argCusId;
    this.venName = argVenName;
    this.venStatus = argVenStatus;
    this.venNo = argVenNo;

  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Vendor vendor = (Vendor) obj;
    if (Objects.equals(venId, vendor.venId )||Objects.equals(cusId, vendor.cusId )||Objects.equals(venName, vendor.venName)||Objects.equals(venStatus, vendor.venStatus)||Objects.equals(venNo, vendor.venNo ))
    {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode()
     {
    return Objects.hash(venId,cusId,venName,venStatus,venNo);
  }

    /**
     * @return this venID.
     */
  public final String getVenId() {
    return venId;
  }
   /**
     * @return this cusID.
     */

  public final String getCusId() {
      return cusId; 
  }
   /**
     * @return this VenName.
     */
  public final String getVenName() {
    return venName;
  }
  /**
     * @return this VenStatus.
     */
  public final String getVenStatus() {
      return venStatus; 
  }
  /**
     * @return this VenNo.
     */
  public final String getVenNo() {
    return venNo; 
}
    /**
     * @param argVenId gets the  venId.
     */
  public final void setVenId(final String argVenId) 
  {
    this.venId = argVenId;
  }
  /**
     * @param argCusId gets the  cusId.
     */
  public final void setCusId(final String argCusId) 
  {
    this.cusId = argCusId;
  }
  /**
     * @param argVenName gets the  venName.
     */
  public final void setVenName(final String argVenName) 
  {
    this.venName = argVenName;
  }
  /**
     * @param argVenStatus gets the  venStatus.
     */
  public final void setVenStatus(final String argVenStatus) 
  {
    this.venStatus= argVenStatus;
  }
  /**
     * @param argVenNo gets the  venNo.
     */
  public final void setVenNo(final String argVenNo) 
  {
    this.venNo= argVenNo;
  }
}
 