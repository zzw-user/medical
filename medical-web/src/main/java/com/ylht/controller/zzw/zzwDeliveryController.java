package com.ylht.controller.zzw;

import com.ylht.pojo.Delivery;
import com.ylht.pojo.Mpuser;
import com.ylht.service.DeliveryService;
import com.ylht.service.DeliverysService;
import com.ylht.service.MpuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("zDelivery")
class ZzwDeliveryController {
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private MpuserService mpuserService;

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
    @RequestMapping("getMpuser")
    public List<Mpuser> getMpuser(){
        return mpuserService.getAll();
    }
    @RequestMapping("updDelivery")
    public boolean updDelivery(Delivery delivery){
        Integer result= deliveryService.upd(delivery);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }
}
