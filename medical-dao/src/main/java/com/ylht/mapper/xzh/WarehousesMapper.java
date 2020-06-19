package com.ylht.mapper.xzh;

import com.ylht.pojo.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WarehousesMapper {
    List<Warehouse> seleWarehouse(@Param("wname") String wname,@Param("address") String address,
           @Param("index")Integer index,@Param("pagesize")Integer pagesize);
}
