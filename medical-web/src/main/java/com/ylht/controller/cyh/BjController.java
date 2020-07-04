package com.ylht.controller.cyh;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Arpart;
import com.ylht.pojo.Information;
import com.ylht.pojo.Type;
import com.ylht.pojo.Warehouse;
import com.ylht.service.ArpartService;
import com.ylht.service.TypeService;
import com.ylht.service.WarehouseService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BjController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private ArpartService arpartService;
    @Autowired
    private WarehouseService warehouseService;

    @RequestMapping("/selectArpartAll")
    public Object selectArpartAll(Integer page,Integer limit,String coding, String aname,Integer tid){
        PageHelper.startPage(page, limit);
        List<Arpart> list =arpartService.selectBj(coding,aname,tid);
        PageInfo<Arpart> pageInfo = new PageInfo(list);
        ResultMap<List<Arpart>> resultMap = new ResultMap("", pageInfo.getList(), 0, pageInfo.getTotal());
        return resultMap;
    }

    @RequestMapping("updateArpart")
    public String updateArpart(Arpart arpart){
       int i= arpartService.upd(arpart);
       return i>0?"true":"false";
    }
    @RequestMapping("deleteArpart")
    public String deleteArpart(Arpart arpart){
        int i= arpartService.del(arpart);
        return i>0?"true":"false";
    }
    @RequestMapping("addArpartcyh")
    public String addArpartcyh(Arpart arpart){
        int i= arpartService.add(arpart);
        return i>0?"true":"false";
    }
    @RequestMapping("selectTypecyh")
    public Object selectType(){
     List<Type> list =   typeService.getAll();
     return list;
    }
    @RequestMapping("selectOneArpartcyh")
    public Object selectOneArpart(Arpart arpart){
        Arpart a  =   arpartService.getOne(arpart);
        return a;
    }
    @RequestMapping("selectWarehousecyh")
    public Object selectWarehouse(){
        List<Warehouse> list =   warehouseService.getAll();
        return list;
    }

}
