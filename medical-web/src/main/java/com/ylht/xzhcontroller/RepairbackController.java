package com.ylht.xzhcontroller;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Payareturnvisit;
import com.ylht.service.PayareturnvisitService;
import com.ylht.service.RepairbackService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Repairback")
public class RepairbackController {
    @Autowired
    private PayareturnvisitService service;
    @Autowired
    private RepairbackService services;


    @RequestMapping("selePayareturnvisit")
    public ResultMap<List<Payareturnvisit>> selePayareturnvisit(String pname, String way,Integer aftertype, Integer page, Integer limit){
        System.out.println(aftertype);
        PageInfo<Payareturnvisit> pages=services.selePayareturnvisit(pname, way,aftertype, page, limit);
        System.out.println(pages.getList());
        return new ResultMap<List<Payareturnvisit>>("",pages.getList(),0,pages.getTotal());
    }


    @RequestMapping("addPayareturnvisit")
    public boolean addPayareturnvisit(Payareturnvisit payareturnvisit){
        Integer a=service.add(payareturnvisit);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("updPayareturnvisit")
    public boolean updPayareturnvisit(Payareturnvisit payareturnvisit){
        Integer a=service.upd(payareturnvisit);

        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("delPayareturnvisit")
    public boolean delPayareturnvisit(Payareturnvisit payareturnvisit){
        Integer a=service.del(payareturnvisit);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("getPayareturnvisitOne")
    public Payareturnvisit getPayareturnvisitOne(Payareturnvisit payareturnvisit){
        Payareturnvisit payareturnvisits=service.getOne(payareturnvisit);
        return payareturnvisits;
    }
}
