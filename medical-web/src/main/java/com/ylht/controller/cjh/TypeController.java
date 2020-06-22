package com.ylht.controller.cjh;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Type;
import com.ylht.service.TypeService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Type")
public class TypeController {


    @Autowired
    private TypeService typeService;

    @RequestMapping("getTypeAll")
    public ResultMap<List<Type>> gettype(String tname, Integer page, Integer limit){
        PageInfo<Type> pageInfo =typeService.getshow(tname, page, limit);
        return  new ResultMap<List<Type>>("",pageInfo.getList(),0,pageInfo.getTotal());

    }

    @RequestMapping("addtype")
    public boolean add(Type type){
        int result=typeService.add(type);
        if (result>0){
            return true;
        }
        return false;
    }

    @RequestMapping("updatetype")
    public boolean upd(Type type){
        int result=typeService.upd(type);
        if (result>0){
            return true;
        }
        return false;
    }

    @RequestMapping("deltype")
    public boolean del(Type type){
        int result=typeService.del(type);
        if (result>0){
            return true;
        }
        return false;
    }

    @RequestMapping("getTypeOne")
    public Type getone(Type type){
        Type types=typeService.getOne(type);
        return types;
    }

}
