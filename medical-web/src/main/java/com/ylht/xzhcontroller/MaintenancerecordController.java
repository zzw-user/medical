package com.ylht.xzhcontroller;

import com.ylht.pojo.Amendrecord;
import com.ylht.pojo.Cost;
import com.ylht.service.AmendrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("Maintenancerecord")
public class MaintenancerecordController {
    @Autowired
    private AmendrecordService service;

    @RequestMapping("addAmendrecord")
    public boolean addAmendrecord(Amendrecord amendrecord){
        Integer a=service.add(amendrecord);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("updAmendrecord")
    public boolean updAmendrecord(Amendrecord amendrecord){
        Integer a=service.upd(amendrecord);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("delAmendrecord")
    public boolean delAmendrecord(Amendrecord amendrecord){
        Integer a=service.del(amendrecord);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("getAmendrecordOne")
    public Amendrecord getAmendrecordOne(Amendrecord amendrecord){
        Amendrecord amendrecords=service.getOne(amendrecord);
        return amendrecords;
    }
}
