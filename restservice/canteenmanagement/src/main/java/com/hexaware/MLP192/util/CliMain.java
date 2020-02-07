package com.hexaware.MLP192.util;

import java.util.Scanner;
import com.hexaware.MLP192.factory.CustomerFactory;
import com.hexaware.MLP192.factory.MenuFactory;
import com.hexaware.MLP192.factory.OrdersFactory;
import com.hexaware.MLP192.factory.VendorFactory;
import com.hexaware.MLP192.factory.WalletFactory;
import com.hexaware.MLP192.model.Customer;
import com.hexaware.MLP192.model.Menu;
import com.hexaware.MLP192.model.Orders;
import com.hexaware.MLP192.model.Vendor;
import com.hexaware.MLP192.model.Wallet;

/**
 * CliMain used as Client interface for java coding.
 * @Magudi-hexware
 */
class CliMain {
  private static Scanner option = new Scanner(System.in, "UTF-8");

  /**
   * mainMenu method used to display the option we had in the application.
   */
  private void mainMenu() {
    System.out.println("-----------------------");
    System.out.println("1. Customer");
    System.out.println("2. vendor");
    System.out.println("3. order");
    System.out.println("4. Payment");
    System.out.println("5. Menu");
    System.out.println("6. PlaceOrder");
    System.out.println("7. Exit");
    System.out.println("-----------------------");
    System.out.println("Enter your choice");
    final int menuOption = option.nextInt();
    switch (menuOption) {
      case 1:
        showCustomer();
        break;
      case 2:
        showVendor();
        break;
      case 3:
        showOrder();
        break;
      case 4:
        showWallet();
        break;
      case 5:
        showMenu();
      case 6:
        showPlaceOrder();
      case 7:
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Enter the valid input");
    }
  }
  private void showCustomer() {
    int cusId;
    String cusName;
    String cusPwd;
    String cusPh;
    String cusMailAdd;
    System.out.println("-------------------");
    System.out.println("1.Show Customer");
    System.out.println("2.Add Customer");
    System.out.println("3.Update Customer");
    System.out.println("4.Delete Customer");
    System.out.println("-------------------");
    System.out.println("Enter your choice:");
    final int menuOption = option.nextInt();
    switch (menuOption) {
      case 1:
        showFullCustomer();
        break;
      case 2:
        System.out.println("Enter the cusName");
        cusName = option.next();
        System.out.println("Enter the password");
        cusPwd = option.next();
        System.out.println("Enter the date of birth");
        String cusDob = option.next();
        System.out.println("Enter the phone number");
        cusPh = option.next();
        System.out.println("Enter the Address");
        cusMailAdd = option.next();
        System.out.println("Enter the Wallet details");
        float cusWallet = option.nextFloat();
        int i = CustomerFactory.insertCustomer(cusPwd, cusName, cusDob, cusPh, cusMailAdd, cusWallet);
        if (i > 0) {
          System.out.println("inserted succesfully");
        } else {
          System.out.println("not inserted");
        }
        break;
      case 3:
        System.out.println("Enter the customer phone");
        cusPh = option.next();
        System.out.println("Enter the customer Id");
        cusId = option.nextInt();
        int j = CustomerFactory.updateCustomer(cusPh, cusId);
        if (j > 0) {
          System.out.println("updated succesfully");
        } else {
          System.out.println("not updated");
        }
        break;
      case 4:
        System.out.println("Enter the customer phone");
        cusPh = option.next();
        int k = CustomerFactory.deleteCustomer(cusPh);
        if (k > 0) {
          System.out.println("deleted succesfully");
        } else {
          System.out.println("not deleted");
        }
        break;
      case 5:
        Runtime.getRuntime().halt(0);
      default:
        mainMenu();
        break;
    }
  }
  private void showFullCustomer() {
    final Customer[] customer = CustomerFactory.showCustomer();
    System.out.println("CUS_ID" + "\t" + "CUS_PWD" + "\t" + "CUS_NAME" + "\t" + "CUS_DOB" + "\t" + "CUS_PH" + "\t" + "CUS_ADD" + "\t" + "CUS_WALLET");
    for (final Customer c : customer) {
      System.out.print(c.getcusId() + "\t" + c.getcusPwd() + "\t" + c.getcusName()
          + "\t" + c.getcusDob() + "\t" + c.getcusPh() + "\t" + c.getcusMailAdd() + "\t" + c.getcusWallet());
    }
  }

  /**
   * mainMenuDetails method process the option selected from main menu.
   */
  private void showVendor() {
    String venName;
    String venStatus;
    int venId;

    System.out.println("Vendor Table");
    System.out.println("-------------------");
    System.out.println("1.Select");
    System.out.println("2.Insert");
    System.out.println("3.Update");
    System.out.println("4.Delete");
    System.out.println("-------------------");
    System.out.println("Enter your choice:");
    final int menuOption = option.nextInt();
    switch (menuOption) {
      case 1:
        showFullVendor();
        mainMenu();
        break;
      case 2:
        System.out.println("Enter the vendor Name");
        venName = option.next();
        int i = VendorFactory.addVendor(venName);
        if (i > 0) {
          System.out.println("inserted succesfully");
        } else {
          System.out.println("not inserted");
        }
        mainMenu();
        break;
      case 3:
        System.out.println("Enter the vendor Name");
        venStatus = option.next();
        System.out.println("Enter the vendor Id");
        venId = option.nextInt();
        int j = VendorFactory.updateVendor(venStatus, venId);
        if (j > 0) {
          System.out.println("updated succesfully");
        }   else {
          System.out.println("not updated");
        }
        mainMenu();
        break;
      case 4:
        System.out.println("Enter the vendor Name");
        venName = option.next();
        int k = VendorFactory.deleteVendor(venName);
        if (k > 0) {
          System.out.println("deleted succesfully");
        } else {
          System.out.println("not deleted");
        }
        mainMenu();
        break;
      default:
        Runtime.getRuntime().halt(0);
    }
  }

  private void showFullVendor() {
    final Vendor[] vendor = VendorFactory.showVendor();
    System.out.println("VEN_ID" + "\t" + "CUS_ID" + "\t"  + "\t"  + "VEN_NAME"
        + "\t"  + "\t" + "VEN_PASSWORD" + "\t" + "VEN_STATUS" + "\t" + "VEN_NO" + "\t" + "VEN_WALLET");
    for (final Vendor v : vendor) {
      System.out.format("%-5d %7d %19s %15s %15s %13s %10f \n", v.getVenId(), v.getCusId(), v.getVenName(), v.getVenPwd(), v.getVenStatus(),
          v.getVenNo(), v.getVenWallet());
    }
  }

/**
   * showFullMenu method display the menu item stored in database.
   */
  private void showOrder() {
    int ordId;
    String ordItemSel;
    int ordQty;
    System.out.println("order Table");
    System.out.println("-------------------");
    System.out.println("1.Select");
    System.out.println("2.Insert");
    System.out.println("3.Update");
    System.out.println("4.Delete");
    System.out.println("-------------------");
    System.out.println("Enter your choice:");
    final int menuOption = option.nextInt();
    switch (menuOption) {
      case 1:
        showFullOrder();
        mainMenu();
        break;
      case 2:
        System.out.println("Enter the Order date");
        String ordDate = option.next();
        System.out.println("Enter the Order item Selected");
        ordItemSel = option.next();
        System.out.println("Enter the Order item Quantity");
        ordQty = option.nextInt();
        int i = OrdersFactory.insertingORDERS(ordDate, ordItemSel, ordQty);
        if (i > 0) {
          System.out.println("inserted succesfully");
        } else {
          System.out.println("not inserted");
        }
        mainMenu();
        break;
      case 3:
        System.out.println("Enter the Selected Order item ");
        ordItemSel = option.next();
        System.out.println("Enter the Order Id");
        ordId = option.nextInt();
        int j = OrdersFactory.updatingORDERS(ordItemSel, ordId);
        if (j > 0) {
          System.out.println("updated succesfully");
        } else {
          System.out.println("not updatted");
        }
        mainMenu();
        break;
      case 4:
        System.out.println("Enter the order Id");
        ordId = option.nextInt();
        int k = OrdersFactory.deletingORDERS(ordId);
        if (k > 0) {
          System.out.println("deleted succesfully");
        } else {
          System.out.println("not deleted");
        }
        mainMenu();
        break;
      default:
        mainMenu();
    }
  }

  private void showFullOrder() {
    final Orders[] orders = OrdersFactory.showOrders();
    System.out.println("CUS_ID" + "\t" + "ORD_ID" + "\t" + "ORD_DATE" + "\t" + "ORD_ITEMSELL" + "\t" + "ORD_QTY" + "ORD_STATUS");
    for (final Orders o : orders) {
      System.out.format("%3d %3d %10s %15s %5d %15s\n", o.getcusId(),
          o.getordId(), o.getordDate(), o.getordItemSel(), o.getordQty(), o.getordStatus());
    }

  }

  private void showMenu() {
    String foodItemName;
    int  foodItemId;
    Float foodItemAmt;
    System.out.println("Menu Table");
    System.out.println("-------------------");
    System.out.println("1.Select");
    System.out.println("2.Insert");
    System.out.println("3.Update");
    System.out.println("4.Delete");
    System.out.println("-------------------");
    System.out.println("Enter your choice:");
    final int menuOption = option.nextInt();
    switch (menuOption) {
      case 1:
        showFullMenu();
        mainMenu();
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
        mainMenu();
        break;
      case 4:
        System.out.println("Enter the food item Name");
        foodItemName = option.next();
        int k = MenuFactory.deleteMenu(foodItemName);
        if (k > 0) {
          System.out.println("Deleted succesfully");
        } else {
          System.out.println("not deleted");
        }
        mainMenu();
        break;
      default:
        mainMenu();
    }
  }

  private void showFullMenu() {
    final Menu[] menu = MenuFactory.showMenu();
    System.out.println("food_Id" + "\t" + "food_ItemName" + "\t" + "food_ItemAmt" + "\t" + "cus_Id");
    for (final Menu m : menu) {
      System.out.format("%3d %15s %15f %10s\n", m.getfoodId(), m.getfoodItemName(), m.getfoodItemAmt(), m.getcusId());
    }
  }

  private void showWallet() {
    int cusId;
    float walBal;
    String walPayid;
    float walTotamt;
    System.out.println("Wallet Table");
    System.out.println("-------------------");
    System.out.println("1.Select");
    System.out.println("2.Insert");
    System.out.println("3.Update");
    System.out.println("-------------------");
    System.out.println("Enter your choice:");
    final int menuOption = option.nextInt();
    switch (menuOption) {
      case 1:
        showFullWallet();
        mainMenu();
        break;
      case 2:
        System.out.println("Enter the customer id");
        cusId = option.nextInt();
        System.out.println("Enter the wallet balance ");
        walBal = option.nextFloat();
        System.out.println("Enter the wallet payment id");
        walPayid = option.next();
        System.out.println("Enter the total amount");
        walTotamt = option.nextFloat();
        System.out.println("Enter the pay Date");
        String walPayDate = option.next();
        int i = WalletFactory.insertWallet(cusId, walBal, walPayid, walTotamt, walPayDate);
        if (i > 0) {
          System.out.println("inserted succesfully");
        } else {
          System.out.println("not inserted");
        }
        mainMenu();
        break;
      case 3:
        System.out.println("Enter the Customer id");
        cusId = option.nextInt();
        System.out.println("Enter the Wallet balance");
        walBal = option.nextFloat();
        int j = WalletFactory.updateWallet(walBal, cusId);
        if (j > 0) {
          System.out.println("updated succesfully");
        } else {
          System.out.println("not updated");
        }
        mainMenu();
        break;
      default:
        mainMenu();
    }
  }
  private void showFullWallet() {
    final Wallet[] wallet = WalletFactory.showWallet();
    System.out.println("Cus_Id" + "\t" + "Wal_Bal" + "\t" + "WalPayId" + "\t" + "WalTOTAMT" + "\t" + "WALPAYDATE" + "\t" + "WALPAYTIME");
    for (final Wallet w : wallet) {
      System.out.format("%3s %5f %10s %10f %7s %7s\n", w.getcusId(), w.getwalBal(), w.getwalPayid(),
          w.getwalTotamt(), w.getwalPaydate(), w.getwalPaytime());
    }
  }
  private void showPlaceOrder() {
    String name;
    int cusId;
    System.out.println("Enter the customer Name");
    name = option.next();
    Customer c = CustomerFactory.showCusWalletBalance(name);
    System.out.println("YOUR WALLET BALANCE : " + c.getcusWallet());
    System.out.println("ENTER FOOD ID");
    int foodId = option.nextInt();
    Menu m = MenuFactory.showCost(foodId);
    if (foodId == m.getfoodId()) {
      System.out.println("ENTER THE QUANTITY");
      int foodquan = option.nextInt();
      float foodcost = m.getfoodItemAmt();
      float ordertotcost = foodcost * foodquan;
      float cuswalbal = c.getcusWallet();
      if (cuswalbal < ordertotcost) {
        System.out.println("INSUFFICIENT BALANCE");
      } else {
        System.out.println("YOU HAVE SELECTED THE FOOD : " + m.getfoodId());
        System.out.println("TOTAL COST IS : " + ordertotcost);
        cuswalbal = cuswalbal - ordertotcost;
        System.out.println("Enter the customer Id");
        cusId = option.nextInt();
        CustomerFactory.updateCustomerWalBal(cusId, cuswalbal);
        c.setcusWall(cuswalbal);
        System.out.println("SUCCESFULLY PLACED ORDER AND THE WALLET BALANCE Is : " + cuswalbal);
      }
    }
    System.out.println("ARE YOU STILL HUNGRY----->WANT TO PLACE ANOTHER ORDER(Y/N)?");
    String rePlace = option.next().toUpperCase();
    if (rePlace.equals("Y")) {
      showFullMenu();
      showPlaceOrder();
    } else {
      System.out.println("Thank you ... come again");
    }

  }
  /**main method is the basic entry point for the application.
   * @param args use to get the user input.
   */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    System.out.println("----------------------------");
    System.out.println("WELCOME TO GOOD FOODS");
    System.out.println("----------------------------");
    System.out.println("1.Customer");
    System.out.println("2.Vendor");
    System.out.println("----------------------------");
    final int menuOption = option.nextInt();
    switch (menuOption) {
      case 1:
        mainObj.startingCustomer();
        break;
      case 2:
        mainObj.startingVendor();
        break;
      default :
        System.out.println("Either 1 or 2");
    }
  }
  private void startingVendor() {
    System.out.println("Canteen Management System vendor");
    System.out.println("1.Sign Up");
    System.out.println("2.Log In");
    final int menuOption = option.nextInt();
    switch (menuOption) {
      case 1:
        System.out.println("Enter the venName");
        String venName = option.next();
        System.out.println("Enter the password");
        String venPwd = option.next();
        System.out.println("Enter the phone number");
        String venPh = option.next();
        int i = VendorFactory.signupVendor(venName, venPwd, venPh);
        if (i > 0) {
          System.out.println("inserted succesfully");
        } else {
          System.out.println("not inserted");
        }
      case 2:
        System.out.println("Enter the venName");
        String name = option.next();
        System.out.println("Enter the password");
        String password = option.next();
        Vendor v = VendorFactory.loginVendor(name, password);
        try {
          if (v.getVenName().equals(name) && v.getVenPwd().equals(password)) {
            System.out.println("----------------------------");
            System.out.println("WELCOME " + name);
            break;
          }
        } catch (Exception e) {
          System.out.println("SORRY ENTER THE VALID NAME AND PASSWORD");
        }

      default:
        startingVendor();
    }
  }
  private void startingCustomer() {
    System.out.println("Canteen Management System");
    System.out.println("1.Sign Up");
    System.out.println("2.Log In");
    final int menuOption = option.nextInt();
    switch (menuOption) {
      case 1:
        System.out.println("Enter the cusName");
        String cusName = option.next();
        System.out.println("Enter the password");
        String cusPwd = option.next();
        System.out.println("Enter the date of birth");
        String cusDob = option.next();
        System.out.println("Enter the phone number");
        String cusPh = option.next();
        System.out.println("Enter the Address");
        String cusAdd = option.next();
        System.out.println("Enter the Wallet details");
        float cusWallet = option.nextFloat();
        int i = CustomerFactory.insertCustomer(cusPwd, cusName, cusDob, cusPh, cusAdd, cusWallet);
        if (i > 0) {
          System.out.println("inserted succesfully");
        } else {
          System.out.println("not inserted");
        }
        startingCustomer();
      case 2:
        System.out.println("Enter the cusName");
        String name = option.next();
        System.out.println("Enter the password");
        String password = option.next();
        Customer c = CustomerFactory.loginCustomer(name, password);
        try {
          if (c.getcusName().equals(name) && c.getcusPwd().equals(password)) {
            System.out.println("----------------------------");
            System.out.println("WELCOME  :" + name);
            System.out.println("WANT TO PLACE ORDER PRESS 1");
            System.out.println("PRESS ANY NUMBER FOR EXIT");
            int menu = option.nextInt();
            switch (menu) {
              case 1:
                showFullMenu();
                showPlaceOrder();
              default:
                Runtime.getRuntime().halt(0);
            }
          }
        } catch (Exception e) {
          System.out.println("SORRY ENTER THE VALID NAME AND PASSWORD");
        }

      default:
        startingCustomer();

    }

  }
}
