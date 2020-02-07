
package com.hexaware.MLP192.persistence;

import java.util.Date;
import java.util.List;

import com.hexaware.MLP192.model.Wallet;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * WalletDAO class used to fetch data from data base.
 * @author hexware
 */
public interface WalletDAO {
  /**
     * @return the all the Wallet record.
     */
  @SqlQuery("Select * from Wallet")
    @Mapper(WalletMapper.class)
    List<Wallet> showWall();
    /**
     * @param cId for customer id
     * @param wBal for wallet balance
     * @param wPayid for payment id
     * @param wTotamt for total amount
     * @param wPaydate for payment date
     *  @return the all the Wallet record.
     */
  @SqlUpdate("INSERT INTO WALLET(CUS_ID, WAL_BAL, WAL_PAYID, WAL_TOTAMT, WAL_PAYDATE)"
      + " VALUES(:cId, :wBal, :wPayid, :wTotamt, :wPaydate)")
int insertingWallet(@Bind("cId") int cId, @Bind("wBal") float wBal, @Bind("wPayid") String wPayid,
      @Bind("wTotamt") float wTotamt, @Bind("wPaydate") Date wPaydate);
/**
 * @return the all the Wallet record.
 *  @param wBal for wallet balance
 *  @param cusid for customer id
 */
  @SqlUpdate("Update WALLET set WAL_BAL = :wBal where CUS_ID = :cusid")
int updatingWallet(@Bind("wBal") float wBal, @Bind("cusid") int cusid);
}

