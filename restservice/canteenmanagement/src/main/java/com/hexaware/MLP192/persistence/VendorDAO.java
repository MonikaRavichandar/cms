package com.hexaware.MLP192.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP192.model.Vendor;;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface VendorDAO {
    /**
     * @return the all the Vendor record.
     */
  @SqlQuery("Select * from VENDOR")
    @Mapper(VendorMapper.class)
    List<Vendor> showVend();
    /**
     * @return the all the Vendor record.
     * @param venName insert VENName.
     */
  @SqlUpdate("Insert into VENDOR(VEN_NAME) values (:venName)")
  int addingVendor(@Bind("venName")String venName);
  /**
   * @param venName delete VENNAME.
   * @return the all the Vendor record.
   */
  @SqlUpdate("Delete from VENDOR where VEN_NAME = :venName")
  int deletingVendor(@Bind("venName")String venName);
  /**
   * @param venStatus update VENSTATUS.
   *  @return the all the Vendor record.
   * @param venId hh
   */
  @SqlUpdate("update VENDOR set VEN_FSTATUS = (:venStatus) where VEN_ID = (:venId)")
  int updatingVendor(@Bind("venStatus")String venStatus, @Bind("venId")int venId);
  /**
   * @param venName insert VENNAME.
   * @param venPwd insert  VENPwd.
   * @param venNo insert VENno.
   * @return the all the Vendor record.
   */
  @SqlUpdate("Insert into Vendor (VEN_NAME, VEN_PWD, VEN_NO)"
      + " values(:venName, :venPwd, :venNo)")
  int signingVendor(@Bind("venName")String venName, @Bind("venPwd")String venPwd, @Bind("venNO")String venNo);
 /**
* @param venName vendor ph
* @param venPwd vendor id
* @return login.
*/
  @SqlQuery("Select * from VENDOR where VEN_NAME = :venName and VEN_PWD = :venPwd")
@Mapper(VendorMapper.class)
Vendor loginingVendor(@Bind("venName") String venName, @Bind("venPwd") String venPwd);
}
