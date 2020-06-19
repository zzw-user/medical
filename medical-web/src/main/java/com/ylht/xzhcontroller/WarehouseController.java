package com.ylht.xzhcontroller;

import com.ylht.pojo.Warehouse;
import com.ylht.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WarehouseController {
    @Autowired
    public WarehouseService service;

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
