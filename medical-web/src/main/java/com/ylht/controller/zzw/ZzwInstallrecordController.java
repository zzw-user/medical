package com.ylht.controller.zzw;

import com.ylht.pojo.Installrecord;
import com.ylht.service.InstallrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("zInstallrecord")
public class ZzwInstallrecordController {
    @Autowired
    private InstallrecordService installrecordService;

    @RequestMapping("getRecord")
    public List<Installrecord> getRecord(Installrecord installrecord){
        return installrecordService.getRecord(installrecord);
    }
    @RequestMapping("getRecordOne")
    public Installrecord getRecordOne(Installrecord installrecord){
        return installrecordService.getRecordOne(installrecord);
    }
    @RequestMapping("delRecord")
    public boolean delRecord(Installrecord installrecord){
        int result = installrecordService.del(installrecord);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("updRecord")
    public boolean updRecord(Installrecord installrecord){
        int result = installrecordService.upd(installrecord);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }
}
