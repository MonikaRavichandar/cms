
package com.hexaware.MLP192.persistence;

import java.util.List;

import com.hexaware.MLP192.model.Wallet;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
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
}
