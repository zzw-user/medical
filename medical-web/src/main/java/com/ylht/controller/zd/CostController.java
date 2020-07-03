package com.ylht.controller.zd;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.*;
import com.ylht.service.CostService;
import com.ylht.service.CostsSerivce;
import com.ylht.service.MpuserService;
import com.ylht.service.ProductService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Cost")
public class CostController {
    @Autowired
    private CostService costservice;
    @Autowired
    private CostsSerivce costsSerivce;
@Autowired
private MpuserService mpuserService;
    @Autowired
    public ProductService productService;

    @RequestMapping("getCost")
    public ResultMap<List<Cost>> demo(String mname, String address, Integer page, Integer limit){
        PageInfo<Cost> pages=costsSerivce.selectCost(mname,address,page,limit);
        System.out.println("我的值是"+pages);
        System.out.println();
        return new ResultMap<List<Cost>>("",pages.getList(),0,pages.getTotal());


    }
    @RequestMapping("/getMpuser")
    public List<Mpuser> getMpuser(){
        return mpuserService.getAll();
    }

    @RequestMapping("addCost")
    public boolean addCost(Cost cost){

        int result=costservice.add(cost);

        if (result>0){
            return true;
        }
        return  false;
    }
    @RequestMapping("getProductOne")
    public Product getMpuserOne(Product product){
        Product products=productService.getOne(product);
        return products;
    }
    @RequestMapping("updateCost")
    public boolean updCost(Cost cost){
        int result=costservice.upd(cost);
        if (result>0){
            return true;
        }
        return  false;
    }

    @RequestMapping("delCost")
    public boolean delCost(Cost cost){
        int result=costservice.del(cost);
        if (result>0){
            return true;
        }
        return  false;
    }
    @RequestMapping("getCostOne")
    public Cost getCostOne(Cost cost){
        Cost costs=costservice.getOne(cost);
        return costs;
    }

    @RequestMapping("getRoleOne")
    public Cost getCostone(Cost cost){
        Cost costs=costservice.getOne(cost);
        return  costs;
    }

}
