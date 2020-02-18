package com.hexaware.MLP192.model;

import com.hexaware.MLP192.persistence.OrdersDAO;
import com.hexaware.MLP192.factory.OrdersFactory;
//import com.hexaware.MLP192.model.Orders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import mockit.integration.junit4.JMockit;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
//import mockit.integration.junit4.JMockit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class OrdersTest {
  private Orders orders;
  private Date pDate = new Date();
  private Date pDate1 = new Date();
  private SimpleDateFormat sdf;

  /**
   * setup method .
   * @throws ParseException .
   */
  @Before
  public final void initInput() throws ParseException {
    //orders = new Orders();
    final String custdob1 = "12/02/2020 10:09:32";
    final String custdob2 = "24/02/2020 10:09:32";
    sdf = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
    sdf.setLenient(false);
    pDate = sdf.parse(custdob1);
    pDate1 = sdf.parse(custdob2);
  }

  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testOrders() {
    //final Orders o = new Orders();
    final Orders o100 = new Orders(103, 1, pDate, "idly", 3, "ORDER PLACED", 60f, 100);
    final Orders o101 = new Orders(103, 2, pDate1, "idly", 2, "ORDER PLACED", 40f, 100);
    assertNotEquals(o100, null);
    assertNotEquals(o101, null);
    assertEquals(o100, new Orders(103, 1, pDate, "idly", 3, "ORDER PLACED", 60f, 100).gettokenId());
    assertEquals(o101, new Orders(103, 2, pDate1, "idly", 2, "ORDER PLACED", 40f, 100));
    assertEquals(o100.hashCode(), new Orders(103, 1, pDate, "idly", 3, "ORDER PLACED", 60f, 100).hashCode());
    assertEquals(o100, new Orders(103, 1, pDate, "idly", 3, "ORDER PLACED", 60f, 100));
  }

  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final OrdersDAO dao) {
    new Expectations() {
      {
        dao.showOrder();
        result = new ArrayList<Orders>();
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    final Orders[] me = OrdersFactory.showOrders();
    assertEquals(0, me.length);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   *
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final OrdersDAO dao) {
    final Orders o100 = new Orders(103, 1, pDate, "idly", 3, "ORDER PLACED", 60f, 100);
    final Orders o101 = new Orders(103, 2, pDate1, "idly", 2, "ORDER PLACED", 40f, 100);
    final ArrayList<Orders> cu = new ArrayList<Orders>();
    new Expectations() {
      {
        cu.add(o100);
        cu.add(o101);
        dao.showOrder();
        result = cu;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    final Orders[] cu1 = OrdersFactory.showOrders();
    assertEquals(2, cu1.length);
    assertEquals(new Orders(103, 1, pDate, "idly", 3, "ORDER PLACED", 60f, 100).gettokenId(), cu1[0].gettokenId());
    assertEquals(new Orders(103, 2, pDate1, "idly", 2, "ORDER PLACED", 40f, 100).gettokenId(), cu1[1].gettokenId());
  }
}

