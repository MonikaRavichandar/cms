
package com.hexaware.MLP192.factory;
import java.util.Date;
//import java.util.Date;
import java.util.List;

import com.hexaware.MLP192.model.Offers;
import com.hexaware.MLP192.persistence.DbConnection;
import com.hexaware.MLP192.persistence.OffersDAO;
/**
 * OffersFactory class used to fetch wallet data from database.
 * @author hexware
 */
public class OffersFactory {
  /**
   *  Protected constructor.
   */
  protected OffersFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OffersDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OffersDAO.class);
  }
  /**
   /**
   * Call the data base connection.
   * @return the array of offers object.
   */
  public static Offers[] showWallet() {
    List<Offers> offers = dao().showWall();
    return offers.toArray(new Offers[offers.size()]);
  }
  /**
   * @param  cusId id
   * @param ordId bal
   * @param venId paymentid
   * @param foodName total amt
   * @param coupCode paydate
   * @param coupDate date
   * @return  i
   * */
  public static int insertOffers(final int cusId, final int ordId, final int venId,
      final String foodName, final String coupCode, final Date coupDate) {
    int i = dao().insertingOffers(cusId, ordId, venId, foodName, coupCode, coupDate);
    return i;
  }
  /**
   * @param  cusId id
   * @return j
   * */
  public static int getOfCusId(final int cusId) {
    int j = dao().gettingCusId(cusId);
    return j;
  }
  /**
   * @param  cusId id
   * @return j
   * */
  public static Date getDate(final int cusId) {
    Date j = dao().gettingDoB(cusId);
    return j;
  }
}

