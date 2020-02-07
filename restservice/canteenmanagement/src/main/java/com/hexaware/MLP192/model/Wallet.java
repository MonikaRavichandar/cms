package com.hexaware.MLP192.model;
import java.util.Objects;
import java.util.Date;
/**
 * Wallet class used to display wallet information.
 * @author hexware
 */

public class Wallet {
/**
 * cusId to store cusId.
 * walBal to store wallet bal.
 * walPayid to store wallet payment id
 * walTotamt to store total amt
 * walPaytime to store payment time
 * walPaydate to store payment date.
 */

  private int cusId;
  private float walBal;
  private String walPayid;
  private float walTotamt;
  private Date walPaydate;
  private Date walPaytime;
   /**
   * Default Constructor.
   */
  public Wallet() {
  }

  /**
   * @param argcusId      to initialize customer id
   * @param argwalBal     to initialize wallet balance
   * @param argwalPayid    to intialize wallet pay id
   * @param argwalPaytime   to intialize wallet paytime
   * @param argwalPaydate   to initialize wallet paydate
   * @param argwalTotamt    to intialize wallet totamt
   */
  public Wallet(final int argcusId, final float argwalBal, final String argwalPayid, final Date argwalPaytime,
      final Date argwalPaydate, final float argwalTotamt) {
    this.cusId = argcusId;
    this.walBal = argwalBal;
    this.walPayid = argwalPayid;
    this.walPaytime = argwalPaytime;
    this.walPaydate = argwalPaydate;
    this.walTotamt = argwalTotamt;

  }

  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Wallet bal = (Wallet) obj;
    if (Objects.equals(cusId, bal.cusId) || Objects.equals(walBal, bal.walBal) || Objects.equals(walPayid, bal.walPayid)
          || Objects.equals(walPayid, bal.walPayid) || Objects.equals(walTotamt, bal.walTotamt) || Objects.equals(walPaydate, bal.walPaydate)
          || Objects.equals(walPaytime, bal.walPaytime)) {
      return true;
    }
    return false;
  }

  @Override
    public final int hashCode() {
    return Objects.hash(cusId, walBal, walPayid, walTotamt, walPaydate, walPaytime);
  }
  /**
     * @return this cusId.
     */
  public final int getcusId() {
    return cusId;
  }
  /**
     * @return this walBal.
     */
  public final float getwalBal() {
    return walBal;
  }
  /**
     * @return this walPayid.
     */
  public final String getwalPayid() {
    return walPayid;
  }
  /**
     * @return this walTotamt.
     */
  public final float getwalTotamt() {
    return walTotamt;
  }
  /**
     * @return this walPaydate.
     */
  public final Date getwalPaydate() {
    return walPaydate;
  }
  /**
     * @return this walPaytime.
     */
  public final Date getwalPaytime() {
    return walPaytime;
  }
    /**
     * @param argcusId gets the cus id.
     */
  public final void setcusId(final int argcusId) {
    this.cusId = argcusId;
  }
  /**
     * @param argwalBal gets the wal bal.
     */
  public final void setwalBal(final float argwalBal) {
    this.walBal = argwalBal;
  }
  /**
     * @param argwalPayid gets the wal pay id.
     */
  public final void setwalPayid(final String argwalPayid) {
    this.walPayid = argwalPayid;
  }
  /**
     * @param argwalTotamt gets the wal tot amt.
     */
  public final void setwalTotamt(final Float argwalTotamt) {
    this.walTotamt = argwalTotamt;
  }
  /**
 * @param argwalPaydate gets the wal pay date.
  */
  public final void setwalPaydate(final Date argwalPaydate) {
    this.walPaydate = argwalPaydate;
  }
  /**
     * @param argwalPaytime gets the wal pay time.
     */
  public final void setwalPaytime(final Date argwalPaytime) {
    this.walPaytime = argwalPaytime;
  }
}
