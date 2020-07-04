package com.ylht.liujiancontroller;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Arparts;
import com.ylht.pojo.Product;
import com.ylht.service.ProductandWarehouseService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class pageinfoproductAndInventoryController {
    @Autowired
    private ProductandWarehouseService productandWarehouseService;
    @RequestMapping("pageinfoproductAndInventory")
    public Object pageinfoproductAndInventory(Integer page,Integer limit ,String pname){
        PageInfo<Product> pageinfo=productandWarehouseService.pageinfoproductAndInventory(page,limit,pname);
        ResultMap<List<Product>> resultMap = new ResultMap<List<Product>>("",pageinfo.getList(),0,pageinfo.getTotal());
        return resultMap;
    }
    @RequestMapping("arpartAndInventory")
    public Object arpartAndInventory(Integer page,Integer limit ,String aname){
        PageInfo<Arparts> pageinfo=productandWarehouseService.arpartAndInventory(page,limit,aname);
        ResultMap<List<Arparts>> resultMap = new ResultMap<List<Arparts>>("",pageinfo.getList(),0,pageinfo.getTotal());
        return resultMap;
    }
}
