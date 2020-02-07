
package com.hexaware.MLP192.factory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.hexaware.MLP192.model.Wallet;
import com.hexaware.MLP192.persistence.DbConnection;
import com.hexaware.MLP192.persistence.WalletDAO;
/**
 * WalletFactory class used to fetch wallet data from database.
 * @author hexware
 */
public class WalletFactory {
  /**
   *  Protected constructor.
   */
  protected WalletFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static WalletDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(WalletDAO.class);
  }
  /**
   /**
   * Call the data base connection.
   * @return the array of wallet object.
   */
  public static Wallet[] showWallet() {
    List<Wallet> wallet = dao().showWall();
    return wallet.toArray(new Wallet[wallet.size()]);
  }
  /**
   * @param  cusId id
   * @param walBal bal
   * @param walPayid paymentid
   * @param walTotamt total amt
   * @param walPaydate paydate
   * @return  i
   */
  public static int insertWallet(final int cusId, final float walBal, final String walPayid,
      final float walTotamt, final String walPaydate) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date od = null;
    try {
      od = sdf.parse(walPaydate);
    } catch (ParseException e) {
      System.out.println("Enter valid Date");
    }
    int i = dao().insertingWallet(cusId, walBal, walPayid, walTotamt, od);
    return i;
  }
  /**
  *@param cusid id
  *@param wBal bal
  *@return values
  */
  public static int updateWallet(final float wBal, final int cusid) {
    int j = dao().updatingWallet(wBal, cusid);
    return j;
  }
}
