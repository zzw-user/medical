package com.ylht.xzhcontroller;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Amendrecord;
import com.ylht.pojo.Cost;
import com.ylht.pojo.Delivery;
import com.ylht.service.DeliveryService;
import com.ylht.service.ServicedeliveryService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("delivery")
public class ServicedeliveryController {
    @Autowired
    public DeliveryService service;
    @Autowired
    public ServicedeliveryService services;

    @RequestMapping("getDelivery")
    public ResultMap<List<Delivery>> getDelivery(String mname, String address, Integer page, Integer limit){
        PageInfo<Delivery> pages=services.seleDelivery(mname,address,page,limit);
        return new ResultMap<List<Delivery>>("",pages.getList(),0,pages.getTotal());
    }

    @RequestMapping("addDelivery")
    public boolean addDelivery(Delivery delivery){
        delivery.setDeliverytime(new Date());
        delivery.setAftertype(2);
        Integer a=service.add(delivery);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("updDelivery")
    public boolean updDelivery(Delivery delivery){
        System.out.println(delivery);
        Integer a=service.upd(delivery);
        System.out.println(a);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("delDelivery")
    public boolean delAmendrecord(Delivery delivery){
        Integer a=service.del(delivery);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("getDeliveryOne")
    public Delivery getDeliveryOne(Delivery delivery){
        Delivery deliverys=service.getOne(delivery);
        return deliverys;
    }
}
