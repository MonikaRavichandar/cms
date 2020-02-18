
package com.hexaware.MLP192.util;

import java.util.Scanner;
import com.hexaware.MLP192.factory.VendorFactory;
import com.hexaware.MLP192.model.Vendor;
/**
 * VendorUtil.java used as Client interface for java coding.
 * @Monika-hexware
 */
class VendorUtil {
  private static Scanner option = new Scanner(System.in, "UTF-8");
 /**
 * CustomerUtil.java used as Client interface for java coding.
 * @Monika-hexware
 */
  public void vendorMain() {
    System.out.println("VENDOR");
    System.out.println("1.Sign Up");
    System.out.println("2.Log In");
    final int menuOption = option.nextInt();
    switch (menuOption) {
      default:
        vendorMain();
        break;
      case 1:
        System.out.println("Enter the venName");
        String venName = option.next();
        System.out.println("Enter the password");
        String venPwd = option.next();
        System.out.println("Enter the phone number");
        String venPh = option.next();
        int i = VendorFactory.signupVendor(venName, venPwd, venPh);
        if (i > 0) {
          System.out.println("signup succesfully");
        } else {
          System.out.println("try again");
        }
        break;
      case 2:
        System.out.println("Enter the venName");
        String name = option.next();
        System.out.println("Enter the password");
        String password = option.next();
        Vendor v = VendorFactory.loginVendor(name, password);
         /**
 * CliMain used as Client interface for java coding.
 * @Magudi-hexware
 */
        OrdersUtil odUtil = new OrdersUtil();
        try {
          if (v.getVenName().equals(name) && v.getVenPwd().equals(password)) {
            System.out.println("----------------------------");
            System.out.println("WELCOME " + name.toUpperCase());
            System.out.println("----------------------------");
            System.out.println("1.VIEW ORDERS");
            System.out.println("2.VENDOR WALLET");
            System.out.println("3.VIEW AND EDIT PERSONAL DETAILS");
            System.out.println("4.FOR EXIT");
            int menu = option.nextInt();
            switch (menu) {
              case 1:
                odUtil.venValidation();
                break;
              case 2:
                vendorWallet();
                break;
              case 3:
                showVendor();
                break;
              case 4:
                Runtime.getRuntime().halt(0);
                break;
              default:
                vendorMain();
                break;
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("Enter a valid data");
        }
    }
  }
  private void vendorWallet() {
    System.out.println("Enter the vendor Id");
    int venId = option.nextInt();
    Vendor v = VendorFactory.showVenWalletBalance(venId);
    System.out.println("YOUR WALLET BALANCE : " + v.getVenWallet());
  }
  private void showVendor() {
    String venStatus;
    int venId;
    System.out.println("Vendor Table");
    System.out.println("-------------------");
    System.out.println("1.View");
    System.out.println("2.Edit");
    System.out.println("-------------------");
    System.out.println("Enter your choice:");
    final int menuOption = option.nextInt();
    switch (menuOption) {
      case 2:
        System.out.println("Enter the vendor phone NO: ");
        venStatus = option.next();
        System.out.println("Enter the vendor Id");
        venId = option.nextInt();
        int j = VendorFactory.updateVendor(venStatus, venId);
        if (j > 0) {
          System.out.println("updated succesfully");
        }   else {
          System.out.println("not updated");
        }
        break;
      case 1:
        final Vendor[] vendor = VendorFactory.showVendor();
        System.out.println("VEN_ID"  + "\t"  + "\t"  + "VEN_NAME"
             + "\t"  + "\t" + "VEN_PASSWORD" + "\t" + "VEN_NO" + "\t" + "VEN_WALLET");
        for (final Vendor v : vendor) {
          System.out.format("%-5d %7s %19s  %15s  %10f  %n", v.getVenId(), v.getVenName(), v.getVenPwd(),
                   v.getVenNo(), v.getVenWallet());
        }
      default:
        Runtime.getRuntime().halt(0);
        vendorMain();
    }
  }
}
