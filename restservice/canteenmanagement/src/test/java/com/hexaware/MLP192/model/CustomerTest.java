package com.hexaware.MLP192.model;

import com.hexaware.MLP192.persistence.CustomerDAO;
import com.hexaware.MLP192.factory.CustomerFactory;
//import com.hexaware.MLP192.model.Customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Test class for Customer.
 */
@RunWith(JMockit.class)
public class CustomerTest {
  private Date pDate = new Date();
  private Date pDate1 = new Date();
  private SimpleDateFormat sdf;
    /**
     * setup method .
     * @throws ff
     * @throws ParseException .
     */
  public final void initInput() throws ParseException {
    //customer = new Customer();
    String custdob1 = "12/02/2020 10:09:32";
    String custdob2 = "24/02/2020 10:09:32";
    sdf = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
    sdf.setLenient(false);
    pDate = sdf.parse(custdob1);
    pDate1 = sdf.parse(custdob2);
  }
    /**
   * setup method.
   */
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testCustomer() {
    //Customer c = new Customer();
    Customer c101 = new Customer(100, "Dfhg", "arun", pDate, "794896048", "arun@gmail.com", 1000.0f);
    Customer c102 = new Customer(101, "123", "manoj",  pDate1, "98754624", "manoj@hexaware", 2000.0f);
    assertNotEquals(c101, null);
    assertNotEquals(c102, null);
    assertEquals(c101.getcusId(), new Customer(100, "Dfhg", "arun", pDate, "794896048", "arun@gmail.com", 1000.0f).getcusId());
    assertEquals(c102, new Customer(100, "Dfhg", "arun", pDate, "794896048", "arun@gmail.com", 1000.00f));
    assertEquals(c102.hashCode(), new Customer(101, "123", "manoj", pDate1, "98754624", "manoj@hexaware", 2000.0f).hashCode());
    assertEquals(c102, new Customer(100, "Dfhg", "arun", pDate, "794896048", "arun@gmail.com", 1000.0f));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final CustomerDAO dao) {
    new Expectations() {
      {
        dao.showCus();
        result = new ArrayList<Customer>();
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };
    Customer[] me = CustomerFactory.showCustomer();
    assertEquals(0, me.length);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   *
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final CustomerDAO dao) {
    final Customer c101 = new Customer(100, "Dfhg", "arun", pDate, "794896048", "arun@gmail.com", 100.0f);
    final Customer c102 = new Customer(101, "123", "manoj", pDate1, "98754624", "manoj@hexaware", 2000.0f);
    final ArrayList<Customer> cu = new ArrayList<Customer>();
    new Expectations() {
      {
        cu.add(c101);
        cu.add(c102);
        dao.showCus();
        result = cu;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };
    Customer[] cu1 = CustomerFactory.showCustomer();
    assertEquals(2, cu1.length);
    assertEquals(new Customer(100, "Dfhg", "arun", pDate, "794896048", "arun@gmail.com", 1000.0f).getcusId(), cu1[0].getcusId());
    assertEquals(new Customer(101, "123", "manoj",  pDate1, "98754624", "manoj@hexaware", 2000.0f).getcusId(), cu1[1].getcusId());
  }
}

