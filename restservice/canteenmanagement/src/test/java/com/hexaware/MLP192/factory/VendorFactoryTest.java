package com.hexaware.MLP192.factory;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;


import com.hexaware.MLP192.model.Vendor;
import com.hexaware.MLP192.persistence.VendorDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
/**
 * Test class for Vendor.
 */
public class VendorFactoryTest {
  /**
   * Tests the equals/hashcode methods of the Vendor class.
   */
  /**
   * @param dao mocking the dao class
   */

  @Test
  public final void testGetAllVendor(@Mocked final VendorDAO dao) {
    final Vendor v1 = new Vendor(101, "goodfoods", "food123", "9344552124", 40);
    final ArrayList<Vendor> venList = new ArrayList<Vendor>();
    new Expectations() {
      {
        venList.add(v1);
        dao.showVend();
        result = venList;
      }
    };

    new MockUp<VendorFactory>() {

      @Mock
      VendorDAO dao() {
        return dao;
      }
    };

    Vendor[] vn1 = VendorFactory.showVendor();
    assertEquals(v1, vn1[0]);

  }
/**
   * tests that customer login is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void loginVendor(@Mocked final VendorDAO dao) {
    final Vendor v1 = new Vendor(101, "goodfoods", "food123", "9344552124", 40);
    new Expectations() {
      {
        System.out.println("mocked get vendor login");
        dao.loginingVendor("goodfoods", "food123");
        result = v1;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    Vendor ca = VendorFactory.loginVendor("goodfoods", "food123");
    assertEquals(v1, ca);
  }

  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void showVenWalletBalance(@Mocked final VendorDAO dao) {
    final Vendor expectedS = new Vendor(101, "goodfoods", "food123", "9344552124", 40);
    new Expectations() {
      {
        System.out.println("Mocked find a Vendor");
        dao.showvenWalBal(10);
        result = expectedS;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    Vendor actualS = VendorFactory.showVenWalletBalance(10);
    assertEquals(expectedS, actualS);
  }
  /**
   * tests that customer wallet is handled correctly.
   * @param cdao mocking the dao class
   */
  @Test
  public final void signupVendor(@Mocked final VendorDAO cdao) {
    //final Vendor signS = new Vendor("goodfoods", "food123", "9344552124");
    new Expectations() {
      {
        System.out.println("Mocked find a Vendor");
        cdao.signingVendor("goodfoods", "food123", "9344552124");
        result = 1;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO cdao() {
        System.out.println("Mocked Vendor Dao");
        return cdao;
      }
    };
    int signerS = VendorFactory.signupVendor("goodfoods", "food123", "9344552124");
    assertEquals(1, signerS);
  }
  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void updateVendorWalBal(@Mocked final VendorDAO dao) {
    //1final Vendor updateU = new Vendor(101, "goodfoods", "food123", "9344552124", 40);
    new Expectations() {
      {
        System.out.println("Mocked find a Vendor");
        dao.updatingVendorWal(101, 40);
        result = 1;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int updaterU = VendorFactory.updateVendorWalBal(101, 40);
    assertEquals(1, updaterU);
  }
}

