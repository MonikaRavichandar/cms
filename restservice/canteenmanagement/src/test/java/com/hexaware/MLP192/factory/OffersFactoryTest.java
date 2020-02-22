package com.hexaware.MLP192.factory;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.hexaware.MLP192.model.Offers;
import com.hexaware.MLP192.persistence.OffersDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

 /**
   * tests that updating offers is handled correctly.
   * @throws ParseException throws an exception.
   */
public class OffersFactoryTest {
  private Date d1 = new Date();
  private SimpleDateFormat sdf;
  /**
   * tests that updating offers is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void testGetAllOffers(@Mocked final OffersDAO dao) throws ParseException {
    String date2 = "2020-09-09";
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date2);
    final Offers off = new Offers(100, 102, 2, "soup", "FREE2020", d1);
    final ArrayList<Offers> offersList = new ArrayList<Offers>();
    new Expectations() {
      {
        offersList.add(off);
        dao.showWall();
        result = offersList;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        return dao;
      }
    };

    Offers[] offersList1 = OffersFactory.showOffers();
    assertEquals(off, offersList1[0]);
  }
  /**
   * tests that adding offers is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void addOffers(@Mocked final OffersDAO dao) throws ParseException {
    String date2 = "2020-09-09";
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date2);
    final java.sql.Date sdate = new java.sql.Date(d1.getTime());
    final int oa = 1;
    new Expectations() {
      {
        System.out.println("Mocked find a Vendor");
        dao.insertingOffers(100, 2, "soup", "FREE2020", d1);
        result = oa;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int oa1 = OffersFactory.insertOffers(100, 2, "soup", "FREE2020", d1);
    assertEquals(oa, oa1);
  }
  /**
   * tests that update offers is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void upOffers(@Mocked final OffersDAO dao) throws ParseException {
    final int up = 1;
    new Expectations() {
      {
        System.out.println("Mocked find a Offers");
        dao.gettingCusId(107);
        result = up;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        System.out.println("Mocked Offeres Dao");
        return dao;
      }
    };
    int up1 = OffersFactory.getOfCusId(107);
    assertEquals(up, up1);
  }
  /**
   * tests that update offers is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws an exception.
   */
  @Test
  public final void testGetDate(@Mocked final OffersDAO dao) throws ParseException {
    final String up = "2020-02-18";
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    d1 = sdf.parse(up);
    new Expectations() {
      {
        System.out.println("Mocked find a Offers");
        dao.gettingDate(107);
        result = d1;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        System.out.println("Mocked Offeres Dao");
        return dao;
      }
    };
    Date up1 = OffersFactory.getDate(107);
    assertEquals(d1, up1);
  }
}
