package com.ylht.xzhcontroller;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.*;
import com.ylht.service.AmendrecordService;
import com.ylht.service.ArpartService;
import com.ylht.service.DistrictService;
import com.ylht.service.MaintenancerecordService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("Maintenancerecord")
public class MaintenancerecordController {
    @Autowired
    private AmendrecordService service;
    @Autowired
    private MaintenancerecordService services;
    @Autowired
    private DistrictService servic;
    @Autowired
    private ArpartService servicess;

    public static void uploadImg(MultipartFile file,String path,String name) throws IOException {
        file.transferTo(new File(path,name));
    }
    @RequestMapping("/getAmendrecord")
    public ResultMap<List<Amendrecord>> getAmendrecord(Amendrecord amendrecord, Integer page, Integer limit){
        PageInfo<Amendrecord> pageInfo = services.seleAmendrecord(amendrecord.getAddress(),amendrecord.getStatus(),
                amendrecord.getProductcoding(),amendrecord.getRealname(), page, limit);
        return new ResultMap<List<Amendrecord>>("",pageInfo.getList(),0,pageInfo.getTotal());
    }
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
    @RequestMapping("getDistrict")
    public  List<District> getDistrict(){
        List<District> districts=servic.getAll();
        return districts;
    }
    @RequestMapping("getArpart")
    public Arpart getArpart(Arpart arpart){
        Arpart arparts=servicess.getOne(arpart);
        return arparts;
    }
    @RequestMapping("/upload")
    public Object uploadaaa(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
        //上传的位置
        String path =  request.getSession().getServletContext().getRealPath("/img/");
        //判断该路径是否存在
        File file1 = new File(path);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        //上传文件项
        String filename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String saveName = uuid + "_" + filename.substring(filename.lastIndexOf(File.separator) + 1);
        //file.transferTo(new File(path, saveName));
        uploadImg(file,path,saveName);
        return "{\"code\":0,\"msg\":\""+saveName+"\"}";
    }
}
