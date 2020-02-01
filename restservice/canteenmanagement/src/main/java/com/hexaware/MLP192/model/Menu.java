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
  private String FOODITEMNAME ;

  /**
   * Default Constructor.
   */
  public Menu() {

  }
/**
 * @param argFoodId to initialize food id.
 * used to get details through constructor.
 */
  public Menu(final String argFoodId,final String argFOOD_ITEMNAME) {
    this.foodId = argFoodId;
    this.FOODITEMNAME = argFOOD_ITEMNAME;

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
    if (Objects.equals(foodId, menu.foodId )||Objects.equals(FOODITEMNAME, menu.FOODITEMNAME ))
    {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode()
     {
    return Objects.hash(foodId,FOODITEMNAME);
  }

    /**
     * @return this food ID.
     */
  public final String getFoodId() {
    return foodId;
  }

  public final String getFOOD_ITEMNAME() {
      return FOODITEMNAME; 
  }
    /**
     * @param argFoodId gets the food id.
     */
  public final void setFoodId(final String argFoodId,final String argFOOD_ITEMNAME) {
    this.foodId = argFoodId;
    this.FOODITEMNAME = argFOOD_ITEMNAME;

  }
}
