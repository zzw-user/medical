package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.xzh.WarehousesMapper;
import com.ylht.pojo.Warehouse;
import com.ylht.pojo.Warehouses;
import com.ylht.service.WarehousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WarehousesServiceImpl implements WarehousesService {
    @Autowired
    public WarehousesMapper mapper;


    public PageInfo<Warehouses> seleWarehouse(String wname, String address, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Warehouses> list=mapper.seleWarehouse(wname,address);
        PageInfo<Warehouses> page=new PageInfo<Warehouses>(list);
        return page;
    }

}
