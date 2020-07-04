package com.ylht.mapper;

import com.ylht.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductandWarehouseMapper {
    List<Product> selectproduct(@Param("pname")String pname,@Param("coding") String coding,@Param("wid") Integer wid,@Param("typeid") Integer typeid );
    int updProduct(Product product);
    int addProduct(Product product);
    Product selectProductOne(Integer pid);
    List<Orderforms> selectOrderform(@Param("serialnumber")String serialnumber,@Param("operator")Integer operator,@Param("coding")String coding);
    List<Product> productAndInventory(@Param("pname") String pname);
    List<Arparts> arpartAndInventory(String aname);

}
