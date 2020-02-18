package com.hexaware.MLP192.util;
import java.util.Scanner;
import com.hexaware.MLP192.factory.MenuFactory;
import com.hexaware.MLP192.model.Menu;
/**
 * VendorUtil.java used as Client interface for java coding.
 * @Monika-hexware
 */
class MenuUtil {
  private static Scanner option = new Scanner(System.in, "UTF-8");
  /* private void showMenu() {
    String foodItemName;
    int  foodItemId;
    Float foodItemAmt;
    System.out.println("Menu Table");
    System.out.println("-------------------");
    System.out.println("1.Select");
    System.out.println("2.Insert");
    System.out.println("3.Update");
    System.out.println("-------------------");
    System.out.println("Enter your choice:");
    final int menuOption = option.nextInt();
    switch (menuOption) {
      case 1:
        showFullMenu();
        break;
      case 2:
        System.out.println("Enter the food item id");
        foodItemId = option.nextInt();
        System.out.println("Enter the food item Name");
        foodItemName = option.next();
        int i = MenuFactory.addMenu(foodItemId, foodItemName);
        if (i > 0) {
          System.out.println("inserted succesfully");
        } else {
          System.out.println("not inserted");
        }
        break;
      case 3:
        System.out.println("Enter the food Item Amt");
        foodItemAmt = option.nextFloat();
        System.out.println("Enter the food item id");
        foodItemId = option.nextInt();
        int j = MenuFactory.updateMenu(foodItemId, foodItemAmt);
        if (j > 0) {
          System.out.println("Updated succesfully");
        } else {
          System.out.println("not updated");
        }
        break;
      default:
    }
  } */
  /**
   * showFullMenu method display the menu item stored in database.
   */
  public void showFullMenu() {
    final Menu[] menu = MenuFactory.showMenu();
    System.out.println("food_Id" + "\t" + "food_ItemName" + "\t" + "food_ItemAmt" + "\t" + "cus_Id");
    for (final Menu m : menu) {
      System.out.format("%3d %15s %15f %10s\n", m.getfoodId(), m.getfoodItemName(), m.getfoodItemAmt(), m.getvenId());
    }
  }
}
