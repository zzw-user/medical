package com.ylht.controller.zzw;

import com.ylht.pojo.Amendrecord;
import com.ylht.pojo.Installrecord;
import com.ylht.service.AmendrecordService;
import com.ylht.service.InstallrecordService;
import com.ylht.service.MpuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("zAmend")
public class ZzwAmendrecordController {
    @Autowired
    private AmendrecordService amendrecordService;

    @RequestMapping("getRecord")
    public List<Amendrecord> getRecord(Amendrecord amendrecord){
        return amendrecordService.getRecord(amendrecord);
    }
    @RequestMapping("getRecordOne")
    public Amendrecord getRecordOne(Amendrecord amendrecord){
        return amendrecordService.getRecordOne(amendrecord);
    }
    @RequestMapping("delRecord")
    public boolean delRecord(Amendrecord amendrecord){
        int result = amendrecordService.del(amendrecord);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("updRecord")
    public boolean updRecord(Amendrecord amendrecord){
        int result = amendrecordService.upd(amendrecord);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }
}
