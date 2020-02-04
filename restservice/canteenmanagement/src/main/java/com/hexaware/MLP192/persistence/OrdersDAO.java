package com.hexaware.MLP192.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
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
}
