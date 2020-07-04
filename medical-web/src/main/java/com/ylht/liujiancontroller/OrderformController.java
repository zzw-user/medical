package com.ylht.liujiancontroller;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Mpuser;
import com.ylht.pojo.Orderform;
import com.ylht.pojo.Orderforms;
import com.ylht.pojo.Product;
import com.ylht.service.MpuserService;
import com.ylht.service.OrderformService;
import com.ylht.service.ProductandWarehouseService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderformController {
    @Autowired
    private OrderformService orderformService;
    @Autowired
    MpuserService mpuserService;
    @Autowired
    ProductandWarehouseService productandWarehouseService;
    @RequestMapping("addOrderform")
    public Object addOrderform(Orderform orderform){
        int i =orderformService.add(orderform);
        if (i>0){
            return "true";
        }
        return "false";
    }
    @RequestMapping("allMpuser")
    public Object allmpuser(){
        List<Mpuser> list=mpuserService.getAll();
        return list;
    }
    @RequestMapping("selectOrderform")
    public Object selectOrderform(Integer page,Integer limit ,String serialnumber,Integer operator,String coding){
        PageInfo<Orderforms> pageinfo=productandWarehouseService.pagelist(page, limit, serialnumber, operator, coding);
        ResultMap<List<Orderforms>> resultMap = new ResultMap<List<Orderforms>>("",pageinfo.getList(),0,pageinfo.getTotal());
        return resultMap;
    }
    @RequestMapping("delOrderform")
    public Object delOrderform(Orderform orderform){
        int i =orderformService.del(orderform);
        if (i>0){
            return "true";
        }
        return "false";
    }
    @RequestMapping("selectOneOriderform")
    public Object selectOneOriderform(Orderform orderform){
        Orderform orderform1=orderformService.getOne(orderform);
        return orderform1;
    }
    @RequestMapping("updOrderform")
    public Object updOrderform(Orderform orderform){
        int i =orderformService.upd(orderform);
        if (i>0){
            return "true";
        }
        return "false";
    }
}
