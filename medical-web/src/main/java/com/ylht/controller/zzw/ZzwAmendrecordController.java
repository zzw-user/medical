package com.ylht.controller.zzw;

import com.ylht.pojo.Amendrecord;
import com.ylht.pojo.Installrecord;
import com.ylht.service.AmendrecordService;
import com.ylht.service.InstallrecordService;
import com.ylht.service.MpuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    @RequestMapping("updRecordImg")
    public Object updateImg(MultipartFile file, MultipartFile filetwo, String time, Amendrecord amendrecord) throws IOException, ParseException {
        String pufimg=null;
        String suximg =null;
        Date date=null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date = dateFormat.parse(time);
        amendrecord.setInstallationtime(date);
        String path = "E:\\file\\img";
        if(file!=null){
            if (!file.isEmpty()){
                String name=file.getOriginalFilename();
                String newFileName= UUID.randomUUID().toString();
                String suffix=name.substring(name.lastIndexOf("."));
                String newpath=path+"\\"+newFileName+suffix;
                if(suffix.equals(".png") || suffix.equals(".jpg") || suffix.equals(".jpeg")){
                    File nfile = new File(newpath);
                    file.transferTo(nfile);
                    pufimg =newFileName+suffix;
                }
            }
        }
        if(filetwo!=null){
            if (!filetwo.isEmpty()){
                String name=filetwo.getOriginalFilename();
                String newFileName= UUID.randomUUID().toString();
                String suffix=name.substring(name.lastIndexOf("."));
                String newpath=path+"\\"+newFileName+suffix;
                if(suffix.equals(".png") || suffix.equals(".jpg") || suffix.equals(".jpeg")){
                    File nfile = new File(newpath);
                    filetwo.transferTo(nfile);
                    suximg = newFileName+suffix;
                }
            }
        }
        amendrecord.setBeforeinstallation(pufimg);
        amendrecord.setAfterinstallation(suximg);
        int result = amendrecordService.upd(amendrecord);
        if (result>0){
            return true;
        }
        return false;
    }
}
