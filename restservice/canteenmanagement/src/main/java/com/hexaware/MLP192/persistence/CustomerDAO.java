
package com.hexaware.MLP192.persistence;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;

import com.hexaware.MLP192.model.Customer;

/**
 * CustomerDAO class used to fetch data from data base.
 * @author hexware
 */
public interface CustomerDAO {
    /**
     * @return the all the Customer record.
     */
  @SqlQuery("Select * from CUSTOMER")
    @Mapper(CustomerMapper.class)
    List<Customer> showCus();
}
