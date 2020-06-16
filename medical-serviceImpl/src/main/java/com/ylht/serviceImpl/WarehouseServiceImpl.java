package com.ylht.serviceImpl;

import com.ylht.mapper.WarehouseMapper;
import com.ylht.pojo.Warehouse;
import com.ylht.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ylht.service.WarehouseService;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;
    public List<Warehouse> getAll() {
        return warehouseMapper.selectAll();
    }

    public List<Warehouse> getData(Warehouse warehouse) {
        return warehouseMapper.select(warehouse);
    }

    public Warehouse getOne(Warehouse warehouse) {
        return warehouseMapper.selectOne(warehouse);
    }

    public Integer add(Warehouse warehouse) {
        return warehouseMapper.insert(warehouse);
    }

    public Integer del(Warehouse warehouse) {
        return warehouseMapper.delete(warehouse);
    }

    public Integer upd(Warehouse warehouse) {
        return warehouseMapper.updateByPrimaryKey(warehouse);
    }
}
