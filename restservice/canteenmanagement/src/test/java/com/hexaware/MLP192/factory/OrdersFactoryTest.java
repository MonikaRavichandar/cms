
package com.hexaware.MLP192.factory;
import static org.junit.Assert.assertNotEquals;
import com.hexaware.MLP192.model.Orders;
import com.hexaware.MLP192.persistence.OrdersDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

/**
 * initializing customer factory.
 */
public class OrdersFactoryTest {
  /**
   * tests that order is handled correctly.
   * @param dao mocking the dao class
   */
  @Test

  public final void updateORDERS(@Mocked final OrdersDAO dao) {
    final Orders c1 = new Orders(0, 0, null, null, 0, null, 0, 0);
    new Expectations() {
      {
        System.out.println("mocked get Orders");
        int c1 = OrdersFactory.updatingORDERS("idli", 1);
        result = c1;
        }
        };
    new MockUp<OrdersFactory>() {
        @Mock
            OrdersDAO dao() {
            System.out.println("Mocked Orders Dao");
            return dao;
        }
        };
    int ca = OrdersFactory.updatingORDERS("idli", 1);
    assertNotEquals(c1, ca);
  }

  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test

  public final void showOrders(@Mocked final OrdersDAO dao) {
    final Orders orders = new Orders(0, 0, null, null, 0, null, 0, 0);
    new Expectations() {
      {
        System.out.println("Mocked find a order");
        OrdersFactory.showOrders();
        result = orders;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Orders Dao");
        return dao;
      }
    };
    Orders[] actualS = OrdersFactory.showOrders();
    assertNotEquals(orders, actualS);
  }
}
