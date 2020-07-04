package com.ylht.controller.zzw;

import com.ylht.cos.biz.ITencentCosBizService;
import com.ylht.cos.dto.ImageObjectRuten;
import com.ylht.pojo.Installrecord;
import com.ylht.pojo.Mpuser;
import com.ylht.service.InstallrecordService;
import com.ylht.service.MpuserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("zInstallrecord")
public class ZzwInstallrecordController {
    @Autowired
    private InstallrecordService installrecordService;
    @Autowired
    private MpuserService mpuserService;

    @Autowired
    private ITencentCosBizService cosBizService;

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
    @RequestMapping("updRecordImg")
    public Object updateImg(MultipartFile file,MultipartFile filetwo,String time,Installrecord installrecord) throws IOException, ParseException {
        Date date=null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date = dateFormat.parse(time);
        installrecord.setInstallationtime(date);
        String pufimg=null;
        String suximg =null;
        if(file!=null){
            if (!file.isEmpty()){
                String name=file.getOriginalFilename();
                String newFileName= UUID.randomUUID().toString();
                String suffix=name.substring(name.lastIndexOf("."));
                pufimg =newFileName+suffix;
                File  fi=new File(file.getOriginalFilename());
                try {
                    FileUtils.copyInputStreamToFile(file.getInputStream(), fi);
                    installrecord.setBeforeinstallation(pufimg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ImageObjectRuten setObjectUpload = cosBizService.setObjectUpload(pufimg, fi);
                setObjectUpload.setLocation(setObjectUpload.getLocation().substring(7));//去掉http前缀
            }
        }
        if(filetwo!=null){
            if (!filetwo.isEmpty()){
                String name=filetwo.getOriginalFilename();
                String newFileName= UUID.randomUUID().toString();
                String suffix=name.substring(name.lastIndexOf("."));
                suximg = newFileName+suffix;
                File  fi=new File(filetwo.getOriginalFilename());
                try {
                    FileUtils.copyInputStreamToFile(filetwo.getInputStream(), fi);
                    installrecord.setAfterinstallation(suximg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ImageObjectRuten setObjectUpload = cosBizService.setObjectUpload(suximg, fi);
                setObjectUpload.setLocation(setObjectUpload.getLocation().substring(7));//去掉http前缀
            }
        }
        int result = installrecordService.upd(installrecord);
        if (result>0){
            return true;
        }
        return false;
    }
    @RequestMapping("getMpuser")
    public List<Mpuser> getMpuser(){
        return mpuserService.getAll();
    }
}
