package com.ylht.xzhcontroller;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Warehouse;
import com.ylht.service.WarehouseService;
import com.ylht.service.WarehousesService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Warehouse")
public class WarehouseController {
    @Autowired
    public WarehouseService service;
    @Autowired
    public WarehousesService services;

    @RequestMapping("seleWarehouse")
    public ResultMap<List<Warehouse>> seleWarehouse(String wname, String address, Integer page, Integer limit){
        PageInfo<Warehouse> pages=services.seleWarehouse(wname, address, page, limit);
        return new ResultMap<List<Warehouse>>("",pages.getList(),0,pages.getTotal());
    }


    @RequestMapping("addWarehouse")
    public boolean addWarehouse(Warehouse warehouse){
        Integer a=service.add(warehouse);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("updWarehouse")
    public boolean updWarehouse(Warehouse warehouse){
        Integer a=service.upd(warehouse);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("delWarehouse")
    public boolean delWarehouse(Warehouse warehouse){
        Integer a=service.del(warehouse);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("getWarehouseOne")
    public Warehouse getWarehouseOne(Warehouse warehouse){
        Warehouse warehouses=service.getOne(warehouse);
        return warehouses;
    }
}
