package com.ylht.controllerzxz;

import com.ylht.pojo.Delivery;
import com.ylht.pojo.Mpuser;
import com.ylht.service.DeliveryService;
import com.ylht.service.MpuserService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/SendaSingleInstallation")
public class SendaSingleInstallationController {
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private MpuserService mpuserService;
    @RequestMapping("/getDeliveryByAid")
    public ResultMap<List<Delivery>> getDeliveryByAid(Delivery delivery){
        List<Delivery> list = deliveryService.getData(delivery);
        return new ResultMap<List<Delivery>>("",list,0,list.size());
    }
    @RequestMapping("/addDeliveryByAid")
    public String addDeliveryByAid(Delivery delivery){
        int i = deliveryService.add(delivery);
        if (i>0){
            return "ok";
        }else {
            return "no";
        }
    }
    @RequestMapping("/updateDeliveryByAid")
    public String updateDeliveryByAid(Delivery delivery) {
        int i = deliveryService.upd(delivery);
        if (i > 0) {
            return "ok";
        } else {
            return "no";
        }
    }

    @RequestMapping("/getMpuser")
    public List<Mpuser> getMpuser(){
            return mpuserService.getAll();
        }
}
