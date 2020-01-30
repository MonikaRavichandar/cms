package com.hexaware.MLP192.model;
import java.util.Objects;

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Menu {
/**
 * foodId to store foodId.
 */
  private String foodId;
  private String MENITEMNAME ;

  /**
   * Default Constructor.
   */
  public Menu() {

  }
/**
 * @param argFoodId to initialize food id.
 * used to get details through constructor.
 */
  public Menu(final String argFoodId,final String argMEN_ITEMNAME) {
    this.foodId = argFoodId;
    this.MENITEMNAME = argMEN_ITEMNAME;

  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.foodId )||Objects.equals(MENITEMNAME, menu.MENITEMNAME ))
    {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode()
     {
    return Objects.hash(foodId);
  }
  public final String hashCode() {
    return Objects.hash(MENITEMNAME);
  }
    /**
     * @return this food ID.
     */
  public final String getFoodId() {
    return foodId;
  }

  public final String getMEN_ITEMNAME() {
      return MENITEMNAME; 
  }
    /**
     * @param argFoodId gets the food id.
     */
  public final void setFoodId(final String argFoodId,final String argMEN_ITEMNAME) {
    this.foodId = argFoodId;
    this.MENITEMNAME = argMEN_ITEMNAME;

  }
}
