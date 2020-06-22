package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Warehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarehousesService {
    PageInfo<Warehouse> seleWarehouse(String wname,String address, Integer index,Integer pagesize);
}
