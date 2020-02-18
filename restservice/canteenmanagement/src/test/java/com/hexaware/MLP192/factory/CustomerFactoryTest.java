package com.hexaware.MLP192.factory;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hexaware.MLP192.model.Customer;
import com.hexaware.MLP192.persistence.CustomerDAO;

import org.junit.Before;
import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

/**
 * initializing customer factory.
 */
public class CustomerFactoryTest {
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
   * tests that customer login is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void loginCustomer(@Mocked final CustomerDAO dao) {
    final Customer c1 = new Customer(100, "123", "MANOJ", pDate, "9874563211", "manoj@hexaware", 920f);
    new Expectations() {
          {
            System.out.println("mocked get Customer login");
            dao.loginingCustomer("MANOJ", "manoj@hexaware.com");
            result = c1;
          }
      };
    new MockUp<CustomerFactory>() {
          @Mock
      CustomerDAO dao() {
            System.out.println("Mocked Student Dao");
            return dao;
          }
        };
    Customer ca = CustomerFactory.loginCustomer("MANOJ", "manoj@hexaware.com");
    assertEquals(c1, ca);
  }

  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void showCusWalletBalance(@Mocked final CustomerDAO dao) {
    final Customer expectedS = new Customer(100, "123", "MANOJ", pDate1, "9874563211", "manoj@hexaware", 920f);
    new Expectations() {
          {
            System.out.println("Mocked find a Customer");
            dao.showCusWalBal(101);
            result = expectedS;
          }
        };
    new MockUp<CustomerFactory>() {
          @Mock
      CustomerDAO dao() {
          System.out.println("Mocked Customer Dao");
          return dao;
          }
      };
    Customer actualS = CustomerFactory.showCusWalletBalance(101);
    assertEquals(expectedS, actualS);
  }
}
