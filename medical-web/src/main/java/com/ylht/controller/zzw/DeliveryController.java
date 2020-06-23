package com.ylht.controller.zzw;

import com.ylht.pojo.Delivery;
import com.ylht.service.DeliveryService;
import com.ylht.service.DeliverysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("zDelivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @RequestMapping("getDelivery")
    public List<Delivery> getDelivery(Delivery delivery){
        return  deliveryService.getDelivery(delivery);
    }
    @RequestMapping("getDeliveryOne")
    public Delivery getDeliveryOne(Delivery delivery){
        return  deliveryService.getDeliveryOne(delivery);
    }
    @RequestMapping("delDelivery")
    public boolean delDelivery(Delivery delivery){
        Integer result=deliveryService.del(delivery);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }
}
