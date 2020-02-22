package com.hexaware.MLP192.model;

import com.hexaware.MLP192.persistence.OffersDAO;
import com.hexaware.MLP192.factory.OffersFactory;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Test class for Offers.
 */
@RunWith(JMockit.class)
public class OffersTest {
  private Date d1 = new Date();
  private Date d2 = new Date();
  private SimpleDateFormat sdf;
  /**
   * tests that empty employee list is handled correctly.
   * @throws ParseException exception.
   */
  @Before
  public final void initInput() throws ParseException {
    String date1 = "2020/09/09";
    String date2 = "2020/07/05";
    sdf = new SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    d2 = sdf.parse(date2);
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
public final void testOffers() {
    Offers oFF06 = new Offers(100, 102, 2, "soup", "FREE2020", d1);
    Offers oFF07 = new Offers(100, 102, 2, "soup", "FREE2020", d2);
    assertNotEquals(oFF06, null);
    assertNotEquals(oFF07, null);
    assertEquals(oFF06.getCoupCode(),
        new Offers(100, 102, 2, "soup", "FREE2020", d1).getCoupCode());
    assertEquals(oFF06.getFood(),
        new Offers(100, 102, 2, "soup", "FREE2020", d1).getFood());
    assertEquals(oFF06.getCusId(),
        new Offers(100, 102, 2, "soup", "FREE2020", d1).getCusId());
    assertEquals(oFF06.getVenId(),
        new Offers(100, 102, 2, "soup", "FREE2020", d1).getVenId());
    assertEquals(oFF06.getOrdId(),
        new Offers(100, 102, 2, "soup", "FREE2020", d1).getOrdId());
    assertEquals(oFF06.getCoupDate(),
        new Offers(100, 102, 2, "soup", "FREE2020", d1).getCoupDate());
    oFF07.setCoupCode("Free2020");
    oFF07.setCusId(13);
    oFF07.setFood("soup");
    oFF07.setVenId(100);
    oFF07.setOrdId(102);
    assertEquals(oFF06, new Offers(100, 102, 2, "soup", "FREE2020", d1));
    assertEquals(oFF06.hashCode(),
        new Offers(100, 102, 2, "soup", "FREE2020", d1).hashCode());
    assertEquals(oFF06, new Offers(100, 102, 2, "soup", "FREE2020", d1));
  }
/**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final OffersDAO dao) {
    new Expectations() {
      {
        dao.showWall(); result = new ArrayList<Offers>();
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        return dao;
      }
    };
    Offers[] of = OffersFactory.showOffers();
    assertEquals(0, of.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final OffersDAO dao) {
    final Offers oFF06 = new Offers(100, 102, 2, "soup", "FREE2020", d1);
    final Offers oFF07 = new Offers(100, 102, 2, "soup", "FREE2020", d1);
    final ArrayList<Offers> oa = new ArrayList<Offers>();
    new Expectations() {
      {
        oa.add(oFF06);
        oa.add(oFF07);
        dao.showWall(); result = oa;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        return dao;
      }
    };
    Offers[] oa1 = OffersFactory.showOffers();
    assertEquals(2, oa1.length);
    assertEquals(new Offers(100, 102, 2, "soup", "FREE2020", d2).getCoupCode(),
        oa1[0].getCoupCode());
    assertEquals(new Offers(100, 102, 2, "soup", "FREE2020", d2).getCoupCode(),
        oa1[1].getCoupCode());
  }
}

