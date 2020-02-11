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
    * @param ordItemSel items selected.
    * @param cusId items selected.
    * @param ordQty items selected.
    *@param ordDate order Date.
     * @param ordStatus items selected.
     * @param ordCost items cost
    * @return int
    */
  @SqlUpdate("Insert into ORDERS (CUS_ID, ORD_ITEMSEL, ORD_QTY, ORD_DATE, ORD_STATUS, ORD_COST)"
      + " VALUES(:cusId, :ordItemSel, :ordQty, :ordDate, :ordStatus, :ordCost)")
  int insertorders(@Bind("cusId") int cusId,
      @Bind("ordItemSel") String ordItemSel, @Bind("ordQty") int ordQty,
      @Bind("ordDate") Date ordDate, @Bind("ordStatus") String ordStatus, @Bind("ordCost") float ordCost);
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
    * @param ordStatus update order status
    * @param cusId customer id
    *@return the all the order record.
    */
  @SqlUpdate("Update Orders SET ORD_STATUS = :ordStatus where CUS_ID = :cusId")
  int updateOrStatus(@Bind("cusId") int cusId, @Bind("ordStatus") String ordStatus);
  /**
   * @param ordId for order id.
   * @return the cust Id.
   */
  @SqlQuery("select * from Orders where ORD_ID = :ordId")
  @Mapper(OrdersMapper.class)
  Orders validateOrders(@Bind("ordId") int ordId);

  /**
   * @param ordId for order id.
   * @param ordStatus for order Status
   * @return update the status.
   */
  @SqlUpdate("Update Orders SET ORD_STATUS =:ordStatus where ORD_ID = :ordId")
  @Mapper(OrdersMapper.class)
  int delivered(@Bind("ordId") int ordId, @Bind("ordStatus")String ordStatus);

  /**
   * @param ordId form order id.
   * @return them based on order Id.
   */
  @SqlQuery("Select * from Orders where ORD_ID = :ordId")
  @Mapper(OrdersMapper.class)
  Orders getOrderDetails(@Bind("ordId") int ordId);
}
