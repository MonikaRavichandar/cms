
package com.hexaware.MLP192.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP192.model.Wallet;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * WalletMapper class used to fetch wallet data from database.
 * @author hexware
 */
public class WalletMapper implements ResultSetMapper<Wallet> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
    */
  public final Wallet map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
      *@return Wallet
      */
    return new Wallet(rs.getInt("CUS_ID"), rs.getFloat("WAL_BAL"), rs.getString("WAL_PAYID"),
      rs.getDate("WAL_PAYTIME"), rs.getDate("WAL_PAYDATE"), rs.getFloat("WAL_TOTAMT"));
  }
}

