package com.hexaware.MLP192.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
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
     * @param venId items cost
    * @return int
    */
  @SqlUpdate("Insert into ORDERS (CUS_ID, ORD_ITEMSEL, ORD_QTY, ORD_DATE, ORD_STATUS, ORD_COST, VEN_ID)"
      + " VALUES(:cusId, :ordItemSel, :ordQty, :ordDate, :ordStatus, :ordCost, :venId)")
  int insertorders(@Bind("cusId") int cusId,
      @Bind("ordItemSel") String ordItemSel, @Bind("ordQty") int ordQty,
      @Bind("ordDate") String ordDate, @Bind("ordStatus") String ordStatus, @Bind("ordCost") float ordCost, @Bind("venId") int venId);
   /**
    *@param tokenId items id
    * @param ordItemSel items selected.
    * @return hh
    */
  @SqlUpdate("Update ORDERS set ORD_ITEMSEL = (:ordItemSel) where TOKEN_ID = (:tokenId)")
   int updateORDERS(@Bind("ordItemSel")String ordItemSel, @Bind("tokenId")int tokenId);
  /**
    * @param tokenId customer id
    * @param ordItemSel items selected.
    * @param cusId items selected.
    * @param ordQty items selected.
    * @return hh
    */
  @SqlQuery("select * from ORDERS where CUS_ID = :cusId, TOKEN_ID = : tokenId, ORDITEMSEL = :ordItemSel, ORD_QTY = :ordQty")
    Orders showOrderMenu(@Bind("cusId")int cusId, @Bind("tokenId")int tokenId, @Bind("ordItemSel")String ordItemSel, @Bind("ordQty")int ordQty);
  /**
    * @param ordStatus update order status
    * @param cusId customer id
    *@return the all the order record.
    */
  @SqlUpdate("Update Orders SET ORD_STATUS = :ordStatus where CUS_ID = :cusId")
  int updateOrStatus(@Bind("cusId") int cusId, @Bind("ordStatus") String ordStatus);
  /**
   * @param tokenId for order id.
   * @return the cust Id.
   */
  @SqlQuery("select * from ORDERS where TOKEN_ID = :tokenId")
  @Mapper(OrdersMapper.class)
  Orders validateOrders(@Bind("tokenId") int tokenId);

  /**
   * @param tokenId for order id.
   * @param ordStatus for order Status
   * @return update the status.
   */
  @SqlUpdate("Update Orders SET ORD_STATUS =:ordStatus where TOKEN_ID = :tokenId")
  @Mapper(OrdersMapper.class)
  int delivered(@Bind("tokenId") int tokenId, @Bind("ordStatus")String ordStatus);

  /**
   * @param tokenId form order id.
   * @return them based on order Id.
   */
  @SqlQuery("Select * from ORDERS where TOKEN_ID = :tokenId")
  @Mapper(OrdersMapper.class)
  Orders getOrderDetails(@Bind("tokenId") int tokenId);
   /**
   * @param cusId for order id.
   * @return the cust Id.
   */
  @SqlQuery("select * from ORDERS where CUS_ID = :cusId")
  @Mapper(OrdersMapper.class)
  List<Orders> showCOrders(@Bind("cusId") int cusId);

}
