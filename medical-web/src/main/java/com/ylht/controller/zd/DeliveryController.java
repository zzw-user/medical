package com.ylht.controller.zd;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Delivery;
import com.ylht.service.DeliveryService;
import com.ylht.service.DeliverysService;
import com.ylht.serviceImpl.DeliverysServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DeliveryController {
    @Autowired
    private DeliverysService services;
    @Autowired
    private DeliveryService service;

    @RequestMapping("Tblist")
    @ResponseBody
    public Map<String, Object> demo(String mname, String address, Integer limit, Integer page){
        PageInfo<Delivery> pages=services.selectDelivery(mname,address,limit,page);
        System.out.println("我的值是"+pages);
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("code", "0");
        map.put("msg", "");
        map.put("data",pages.getList());
        map.put("count", pages.getTotal());

        return map;
    }

}
