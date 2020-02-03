package com.hexaware.MLP192.model;
import java.util.Objects;

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Menu {
  /**
   * foodId,foodItemName,foodItemAmt,cusId.
   */
  private String foodId;
  private String foodItemName;
  private Float foodItemAmt;
  private String cusId;
  /**
   * Default Constructor.
   */
  public Menu() {

  }
/**
 * @param argfood_Id to initialize food id.
 * @param argfood_ItemName to initialize food name.
 * @param argfood_ItemAmt to initialize food amount.
 * @param argcus_Id to initialize customer Id.
 * used to get details through constructor.
 */
  public Menu(final String argfood_Id, final String argfood_ItemName, final float argfood_ItemAmt, final String argcus_Id) {
    this.foodId = argfood_Id;
    this.foodItemName = argfood_ItemName;
    this.foodItemAmt = argfood_ItemAmt;
    this.cusId = argcus_Id;
  }

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.foodId) || Objects.equals(foodItemName, menu.foodItemName)
        || Objects.equals(foodItemAmt, menu.foodItemAmt) || Objects.equals(cusId, menu.cusId))
    {
      return true;
    }
    return false;
  }


     public final int hashCode() {
    return Objects.hash(foodId, foodItemName, foodItemAmt, cusId);
  }

  /**
   * @return this food ID.
   */
     public final String getfood_Id() {
    return foodId;
  }
  /**@return this  */
  public final String getfood_ItemName() {
    return foodItemName;
  }

  public final float getfood_ItemAmt() {
    return foodItemAmt;
  }
  public final String getcus_Id(){
    return cusId;
  }

  /**
   * @param argFoodId gets the food id.
   */
  public final void setfoodId(final String argFoodId) {
    this.foodId = argfood_Id;
  }

  public final void setfoodItemName(final String argfood_ItemName) {
    this.foodItemName = argfood_ItemName;
  }

  public final void setfoodAmt(final float argfood_ItemAmt){
    this.foodItemAmt = argfood_ItemAmt;
  }
  public final void setcusId (final String argcus_Id)
  {
    this.cusId = argcus_Id;

  }

}
