package com.ylht.xzhcontroller;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Cost;
import com.ylht.pojo.Mpuser;
import com.ylht.pojo.Product;
import com.ylht.service.CostService;
import com.ylht.service.MaintenancecostsServic;
import com.ylht.service.MpuserService;
import com.ylht.service.ProductService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Maintenancecosts")
public class MaintenancecostsController {
    @Autowired
    public CostService service;
    @Autowired
    public MaintenancecostsServic servic;
    @Autowired
    public MpuserService mpuserService;
    @Autowired
    public ProductService productService;

    @RequestMapping("getCost")
    public ResultMap<List<Cost>> demo(String mname, String address, Integer page, Integer limit){
        PageInfo<Cost> pages=servic.seleCost(mname,address,page,limit);
        return new ResultMap<List<Cost>>("",pages.getList(),0,pages.getTotal());

    }

    @RequestMapping("addCost")
    public boolean addWarehouse(Cost cost){
        cost.setInputtime(new Date());
        Integer a=service.add(cost);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("updCost")
    public boolean updWarehouse(Cost cost){
        Integer a=service.upd(cost);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("delCost")
    public boolean delWarehouse(Cost cost){
        Integer a=service.del(cost);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("getCostOne")
    public Cost getCostOne(Cost cost){
        Cost costs=service.getOne(cost);
        return costs;
    }
    @RequestMapping("getMpuserOne")
    public  List<Mpuser> getMpuserOne(Mpuser mpuser){
        mpuser.setRoleid(4);
        List<Mpuser> mpusers=  mpuserService.getData(mpuser);
        return mpusers;
    }
    @RequestMapping("getProductOne")
    public  Product getMpuserOne(Product product){
        Product products=productService.getOne(product);
        return products;
    }
}
