package com.ylht.liujiancontroller;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Product;
import com.ylht.pojo.Producttype;
import com.ylht.pojo.Warehouse;
import com.ylht.service.*;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductandWarehouseController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductandWarehouseService productandWarehouseService;
    @Autowired
    private ProducttypeService producttypeService;
    @Autowired
    private WarehouseService warehouseService;
    @RequestMapping("selectProduct")
    public Object selectProduct(Integer page,Integer limit ,String pname, String coding, Integer wid, Integer typeid){
        PageInfo<Product> pageinfo=productandWarehouseService.pageinfo(page,limit,pname,coding,wid,typeid);
        ResultMap<List<Product>> resultMap = new ResultMap<List<Product>>("",pageinfo.getList(),0,pageinfo.getTotal());
        return resultMap;
    }
    @RequestMapping("selectProducttype")
    public Object selectProducttype(){
        List<Producttype> list=producttypeService.getAll();
        return list;
    }
    @RequestMapping("selectWarehouse")
    public Object selectWarehouse(){
        List<Warehouse> list=warehouseService.getAll();
        return list;
    }
    @RequestMapping("delProduct")
        public Object delProduct(Product product){
        int i =productService.del(product);
        if (i>0){
            return "true";
        }
        return "false";
    }
    @RequestMapping("selectProductOne")
    public Object selectProductOne(Integer pid){
        Product p =productandWarehouseService.selectProductOne(pid);
        return p;
    }
    @RequestMapping("updProduct")
    public Object updProduct(Product product){
        int i =productandWarehouseService.updProduct(product);
        if (i>0){
            return "true";
        }
        return "false";
    }
    @RequestMapping("addProduct")
    public Object addProduct(Product product){
        int i =productandWarehouseService.addProduct(product);
        if (i>0){
            return "true";
        }
        return "false";
    }
}
