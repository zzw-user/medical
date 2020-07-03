package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Warehouse;

public interface WarehousesService {
    PageInfo<Warehouse> seleWarehouse(String wname, String address, Integer index, Integer pagesize);
}
