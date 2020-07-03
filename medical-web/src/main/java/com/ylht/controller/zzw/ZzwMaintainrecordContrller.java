package com.ylht.controller.zzw;

import com.ylht.pojo.Installrecord;
import com.ylht.pojo.Maintainrecord;
import com.ylht.service.InstallrecordService;
import com.ylht.service.MaintainrecordService;
import com.ylht.service.MpuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("zMaintain")
public class ZzwMaintainrecordContrller {
    @Autowired
    private MaintainrecordService maintainrecordService;

    @RequestMapping("getRecord")
    public List<Maintainrecord> getRecord(Maintainrecord maintainrecord){
        return maintainrecordService.getRecord(maintainrecord);
    }
    @RequestMapping("getRecordOne")
    public Maintainrecord getRecordOne(Maintainrecord maintainrecord){
        return maintainrecordService.getRecordOne(maintainrecord);
    }
    @RequestMapping("delRecord")
    public boolean delRecord(Maintainrecord maintainrecord){
        int result = maintainrecordService.del(maintainrecord);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("updRecord")
    public boolean updRecord(Maintainrecord maintainrecord){
        int result = maintainrecordService.upd(maintainrecord);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }
}
