package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Warehouse;
import com.ylht.pojo.Warehouses;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarehousesService {
    PageInfo<Warehouses> seleWarehouse(String wname, String address, Integer index, Integer pagesize);
}
