package com.ylht.controller.cyh;

import com.ylht.pojo.Cost;
import com.ylht.service.CostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapFinancialAnalsis {
    @Autowired
    private CostService costService;

    public MapFinancialAnalsis() {
    }

    @RequestMapping({"/getAllCost"})
    public Object getAllCost() {
        List<Cost> list = this.costService.getAll();
        return list;
    }
}
