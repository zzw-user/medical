package com.ylht.controllerzxz;

import com.github.pagehelper.PageInfo;
import com.ylht.mapperzxz.DeliveryAndMpuserMapper;
import com.ylht.pojo.Delivery;
import com.ylht.pojo.DeliveryAndMpuser;
import com.ylht.pojo.Mpuser;
import com.ylht.service.DeliveryService;
import com.ylht.service.MpuserService;
import com.ylht.servicezxz.DeliveryAndMpuserService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/SendaSingleInstallation")
public class SendaSingleInstallationController {
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private MpuserService mpuserService;
    @Autowired
    private DeliveryAndMpuserService deliveryAndMpuserService;

    @RequestMapping("/getproductByCoding")
    public int getproductByCoding(String coding){
        return deliveryAndMpuserService.getproductByCoding(coding);
    }

    @RequestMapping("/getDeliveryByAid")
    public ResultMap<List<DeliveryAndMpuser>> getDeliveryByAid(DeliveryAndMpuser deliveryAndMpuser,Integer page,Integer limit){

        PageInfo<DeliveryAndMpuser> pageInfo =deliveryAndMpuserService.pageInfoDeliveryAndMpuser(deliveryAndMpuser.getRealname(),deliveryAndMpuser.getAddress(),deliveryAndMpuser.getCoding(),page,limit);
        return new ResultMap<List<DeliveryAndMpuser>>("",pageInfo.getList(),0,pageInfo.getTotal());
    }
    @RequestMapping("/addDeliveryByAid")
    public String addDeliveryByAid(Delivery delivery,String sj) throws ParseException {
        SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if(sj!=null && sj!=""){
            delivery.setDeliverytime(s.parse(sj));
        }
        int i = deliveryService.add(delivery);
        if (i>0){
            return "ok";
        }else {
            return "no";
        }
    }
    @RequestMapping("/updateDeliveryByAid")
    public String updateDeliveryByAid(Delivery delivery,String sj) throws ParseException {
        System.out.println(delivery);
        SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if(sj!=null && sj!=""){
            delivery.setDeliverytime(s.parse(sj));
        }
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

     @RequestMapping("/getDeliveryByDid")
    public Delivery getDeliveryByDid(Delivery delivery){
        return deliveryService.getOne(delivery);
     }

     @RequestMapping("/deleteDeliveryByDid")
    public String deleteDeliveryByDid(Delivery delivery){
        int i = deliveryService.del(delivery);
         if (i > 0) {
             return "ok";
         } else {
             return "no";
         }
     }
}
