package com.ylht.liujiancontroller;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Cost;
import com.ylht.pojo.Costs;
import com.ylht.pojo.Faultanalysis;
import com.ylht.service.CostService;
import com.ylht.service.CostsService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class costController {
    @Autowired
    private CostService costService;
    @Autowired
    private CostsService costsService;
    @RequestMapping("delcost")
    public Object delcost(Cost cost){
        int i =costService.del(cost);
        if (i>0){
            return "true";
        }
        return "false";
    }
    @RequestMapping("costselectOne")
    public Object costselectOne(Cost cost){
        Cost cost1=costService.getOne(cost);
        return cost1;
    }
    @RequestMapping("costupd")
    public Object costupd(Cost cost){
        int i =costService.upd(cost);
        if (i>0){
            return "true";
        }
        return "false";
    }
    @RequestMapping("costadd")
    public Object costadd(Cost cost){
        int i =costService.add(cost);
        if (i>0){
            return "true";
        }
        return "false";
    }
    @RequestMapping("costselectall")
    public Object costselectall(Integer page, Integer limit,String inputtime,Integer aftertype) throws ParseException {
        Date insdate=null;
        if(inputtime!=null && inputtime!=""){
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            insdate =  s.parse(inputtime);
        }
        PageInfo<Costs> pageinfo=costsService.costspage(page,limit,insdate,aftertype);
        ResultMap<List<Costs>> resultMap = new ResultMap<List<Costs>>("",pageinfo.getList(),0,pageinfo.getTotal());
        return resultMap;
    }
}
