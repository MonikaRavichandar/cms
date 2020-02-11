package com.hexaware.MLP192.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP192.model.Menu;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface MenuDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from MENU")
    @Mapper(MenuMapper.class)
    List<Menu> show();
     /**
     * @return the all the Vendor record.
     * @param foodItemName insert foodItemName.
     * @param foodId insert food id
     */
  @SqlUpdate("Insert into MENU(FOOD_ID, FOOD_ITEMNAME)" + " Values(:foodId, :foodItemName)")
   int addingMenu(@Bind("foodId")int foodId, @Bind("foodItemName")String foodItemName);
  /**
   * @param foodItemName delete foodItemName.
   * @return the all the Menu record.
   */
  @SqlUpdate("Delete FROM  MENU where FOOD_ITEMNAME = :foodItemName")
  int deletingMenu(@Bind("foodItemName")String foodItemName);
  /**
   * @param  foodItemAmt update foodItemAmt.
   * @param  foodId update foodId.
   *  @return the all the Vendor record.
   */
  @SqlUpdate("Update MENU set FOOD_ITEMAMT = :foodItemAmt where FOOD_ID = :foodId")
  int updatingMenu(@Bind("foodId") int foodId, @Bind("foodItemAmt") float foodItemAmt);
  /**
   * @param  foodId update foodItemAmt.
   *  @return the all the Vendor record.
   */
  @SqlQuery("select * from MENU where FOOD_ID = :foodId")
  @Mapper(MenuMapper.class)
  Menu showfoodCost(@Bind("foodId") int foodId);
  /**
   * @param  foodId update foodItemName.
   *  @return the all the Vendor record.
   */
  @SqlQuery("select * from MENU where FOOD_ID = :foodId")
  @Mapper(MenuMapper.class)
  Menu showfName(@Bind("foodId") int foodId);
}
