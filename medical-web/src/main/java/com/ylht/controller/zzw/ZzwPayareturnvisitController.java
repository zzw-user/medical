package com.ylht.controller.zzw;

import com.ylht.pojo.Installrecord;
import com.ylht.pojo.Payareturnvisit;
import com.ylht.service.PayareturnvisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("zPayare")
public class ZzwPayareturnvisitController {
    @Autowired
    private PayareturnvisitService payareturnvisitService;

    @RequestMapping("getPay")
    public List<Payareturnvisit> getPay(Payareturnvisit payareturnvisit){
        return payareturnvisitService.getPayare(payareturnvisit);
    }
    @RequestMapping("getPayOne")
    public Payareturnvisit getPayOne(Payareturnvisit payareturnvisit){
        return payareturnvisitService.getPayareOne(payareturnvisit);
    }
    @RequestMapping("delPay")
    public boolean delPay(Payareturnvisit payareturnvisit){
        int result = payareturnvisitService.del(payareturnvisit);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("updPay")
    public boolean updPay(Payareturnvisit payareturnvisit){
        int result = payareturnvisitService.upd(payareturnvisit);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }
}
