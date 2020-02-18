
package com.hexaware.MLP192.factory;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import com.hexaware.MLP192.model.Menu;
import com.hexaware.MLP192.persistence.MenuDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
/**
 * Test class for Vendor.
 */
public class MenuFactoryTest {
  /**
   * Tests the equals/hashcode methods of the Vendor class.
   */
  /**
   * @param dao mocking the dao class
   */

  @Test
    public final void testGetAllMenu(@Mocked final MenuDAO dao) {
    final Menu cb = new Menu(101, "dosa", 40, 100);
    final ArrayList<Menu> menuList = new ArrayList<Menu>();
    new Expectations() {
      {
        menuList.add(cb);
        dao.show();
        result = menuList;
      }
    };

    new MockUp<MenuFactory>() {

      @Mock
      MenuDAO dao() {
        return dao;
      }
    };

    Menu[] cb1 = MenuFactory.showMenu();
    assertEquals(cb, cb1);
  }
  /**
   * tests that adding menu is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void addMenu(@Mocked final MenuDAO dao) {
    final Menu am = new Menu(101, "dosa", 40f, 100);
    new Expectations() {
      {
        System.out.println("Mocked find Menu");
        dao.addingMenu(101, "dosa", 40f, 100);
        result = am;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
       MenuDAO dao() {
        System.out.println("Mocked Menu Dao");
        return dao;
      }
    };
    int am1 = MenuFactory.addMenu(101, "dosa", 40f, 100);
    assertEquals(am, am1);
  }
 /**
   * tests that updating menu is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void updatingMenu(@Mocked final MenuDAO dao) {
    final Menu up = new Menu(100, null, 40f, 0);
    new Expectations() {
      {
        System.out.println("Mocked find Menu");
        dao.updatingMenu(100, 40f);
        result = up;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
       MenuDAO dao() {
        System.out.println("Mocked Menu Dao");
        return dao;
      }
    };
    int up1 = MenuFactory.updateMenu(100, 40f);
    assertEquals(up, up1);
  }
  /**
   * tests that updating menu is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void chooseMenu(@Mocked final MenuDAO dao) {
    final Menu ch = new Menu(100, null, 40f, 0);
    new Expectations() {
      {
        System.out.println("Mocked find Menu");
        dao.show();
        result = ch;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
       MenuDAO dao() {
        System.out.println("Mocked Menu Dao");
        return dao;
      }
    };
    Menu[] ch1 = MenuFactory.showMenu();
    assertEquals(ch, ch1);
  }
}
