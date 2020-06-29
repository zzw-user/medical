package com.ylht.xzhcontroller;

import com.ylht.pojo.Amendrecord;
import com.ylht.pojo.Delivery;
import com.ylht.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Servicedelivery")
public class ServicedeliveryController {
    @Autowired
    public DeliveryService service;

    @RequestMapping("addDelivery")
    public boolean addDelivery(Delivery delivery){
        Integer a=service.add(delivery);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("updDelivery")
    public boolean updDelivery(Delivery delivery){
        Integer a=service.upd(delivery);
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
