package com.hexaware.MLP192.util;
import java.util.Scanner;
import com.hexaware.MLP192.factory.MenuFactory;
import com.hexaware.MLP192.model.Menu;
import com.hexaware.MLP192.factory.VendorFactory;
import com.hexaware.MLP192.model.Vendor;
/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
public class CliMain {
  private final Scanner option = new Scanner(System.in, "UTF-8");

  /**
   * mainMenu method used to display the option we had in the application.
   */
  private void mainMenu() {
    System.out.println("Canteen Management System");
    System.out.println("-----------------------");
    System.out.println("1.Customer");
    System.out.println("2.Vendor");
    System.out.println("3.Order");
    System.out.println("4.Menu");
    System.out.println("5.Wallet");
    System.out.println("6.Exit ");
    mainMenuDetails();
  }

  /**
   * mainMenuDetails method process the option selected from main menu.
   */
  private void mainMenuDetails() {
    try {
      System.out.println("Enter your choice:");
      final int menuOption = option.nextInt();
      switch (menuOption) {
      case 3:
       showFullMenu();
         break;
       case 6:
        Runtime.getRuntime().halt(0);
        case 2:
System.out.println("Vendor Table");
System.out.println("-------------------");
System.out.println("1.Show Vendor Table");
System.out.println("2.Select");
System.out.println("3.Insert");
System.out.println("4.Update");
System.out.println("4.Delete");
System.out.println("-------------------");
System.out.println("Enter your choice:");
        final int vendorOption = option.nextInt();
        switch (vendorOption) {
        case 1:
          showVendor();
          break;
        case 2:

        case 3:
        case 4:

        case 5:
        case 6:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose either 1 or 2");
        }

      default:
        System.out.println("Choose either 1 or 2");
      }
    } catch (final Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    mainMenu();
  }

  /**
   * showFullMenu method display the menu item stored in database.
   */
  private void showFullMenu() {
    final Menu[] menu = MenuFactory.showMenu();
    System.out.println("food_Id" + "\t" + "food_ItemName" + "\t" + "food_ItemAmt" + "\t" + "cus_Id");
    for (final Menu m : menu) {
      System.out.format("%3s %15s %15f %10s\n", m.getfood_Id(), m.getfood_ItemName(), m.getfood_ItemAmt(),
          m.getcus_Id());
    }
  }

 


  /**
   * main method is the basic entry point for the application.
   * @param args used to get the user input.
   */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
   }
  }

