package com.ylht.controller.zzw;

import com.ylht.pojo.Cost;
import com.ylht.pojo.Payareturnvisit;
import com.ylht.service.CostService;
import com.ylht.service.CostsSerivce;
import com.ylht.service.PayareturnvisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("zCost")
public class ZzwCostController {
    @Autowired
    private CostService costService;

    @RequestMapping("getCost")
    public List<Cost> getPay(Cost cost){
        return costService.getCost(cost);
    }
    @RequestMapping("getCostOne")
    public Cost getPayOne(Cost cost){
        return costService.getCostOne(cost);
    }
    @RequestMapping("delCost")
    public boolean delPay(Cost cost){
        int result = costService.del(cost);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("updCost")
    public boolean updPay(Cost cost){
        int result = costService.upd(cost);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }
}
