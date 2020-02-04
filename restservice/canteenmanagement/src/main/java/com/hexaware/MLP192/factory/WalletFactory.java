
package com.hexaware.MLP192.factory;

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
}
