package com.hexaware.MLP192.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.Date;
import java.util.List;
import com.hexaware.MLP192.model.Orders;
/**
 * ORDERSDAO class used to fetch data from data base.
 * @author priyadharshini
 */
public interface OrdersDAO {
    /**
     * @return the all the ORDERS record.
     */
  @SqlQuery("Select * from ORDERS")
    @Mapper(OrdersMapper.class)
    List<Orders> showOrder();
      /**
   * @param od order date
   * @param ordItemSel ll
   * @param ordQty order quantity
   * @return NN
   */
  @SqlUpdate("Insert into ORDERS (ORD_DATE, ORD_ITEMSEL, ORD_QTY)" + " VALUES(:od, :ordItemSel, :ordQty)")
  int insertORDERS(@Bind("od") Date od, @Bind("ordItemSel") String ordItemSel, @Bind("ordQty") int ordQty);
   /**
    *@param ordId items id
    * @param ordItemSel items selected.
    * @return hh
    */
  @SqlUpdate("Update ORDERS set ORD_ITEMSEL = (:ordItemSel) where ORD_ID = (:ordId)")
   int updateORDERS(@Bind("ordItemSel")String ordItemSel, @Bind("ordId")int ordId);
    /**
    * @param ordId customer id
    * @return hh
    */
  @SqlUpdate("Delete FROM  ORDERS where ORD_ID = :ordId")
 int deleteORDERS(@Bind("ordId")int ordId);
  /**
    * @param ordId customer id
    * @param ordItemSel items selected.
    * @param cusId items selected.
    * @param ordQty items selected.
    * @return hh
    */
  @SqlQuery("select * from ORDERS where CUS_ID = :cusId, ORD_ID = : ordId, ORDITEMSEL = :ordItemSel, ORD_QTY = :ordQty")
    Orders showOrderMenu(@Bind("cusId")int cusId, @Bind("ordId")int ordId, @Bind("ordItemSel")String ordItemSel, @Bind("ordQty")int ordQty);
/**
    * @param ordId customer id
    * @param ordItemSel items selected.
    * @param cusId items selected.
    * @param ordQty items selected.
     * @param ordStatus items selected.
    * @return hh
  @SqlUpdate("Insert into ORDERS (CUS_ID, ORD_ID, ORD_ITEMSEL, ORD_QTY, ORD_DATE, ORD_STATUS)" +
      " values (:cusId, :ordId, :ordItemSel,:ordQty, DATE_ADD(now()), :ordStatus)")
  int placeCusOrder(@Bind("cusId") int cusId, @Bind("ordId") int ordId,
      @Bind("ordItemSel") String ordItemSel, @Bind("ordQty") float ordQty,
       @Bind("ordStatus") String ordStatus);
       */

}
