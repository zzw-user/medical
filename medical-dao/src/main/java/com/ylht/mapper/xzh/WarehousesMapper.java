package com.ylht.mapper.xzh;

import com.ylht.pojo.Warehouse;
import com.ylht.pojo.Warehouses;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WarehousesMapper {
    List<Warehouses> seleWarehouse(@Param("wname") String wname, @Param("address") String address);
}
