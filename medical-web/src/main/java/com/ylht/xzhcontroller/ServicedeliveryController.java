package com.ylht.xzhcontroller;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Amendrecord;
import com.ylht.pojo.Cost;
import com.ylht.pojo.Delivery;
import com.ylht.service.DeliveryService;
import com.ylht.service.ServicedeliveryService;
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
@RequestMapping("delivery")
public class ServicedeliveryController {
    @Autowired
    public DeliveryService service;
    @Autowired
    public ServicedeliveryService services;
    public static void uploadImg(MultipartFile file,String path,String name) throws IOException {
        file.transferTo(new File(path,name));

    }
    @RequestMapping("getDelivery")
    public ResultMap<List<Delivery>> getDelivery(String mname, String address, Integer page, Integer limit){
        PageInfo<Delivery> pages=services.seleDelivery(mname,address,page,limit);
        return new ResultMap<List<Delivery>>("",pages.getList(),0,pages.getTotal());
    }

    @RequestMapping("addDelivery")
    public boolean addDelivery(Delivery delivery){
        delivery.setDeliverytime(new Date());
        delivery.setAftertype(2);
        Integer a=service.add(delivery);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("updDelivery")
    public boolean updDelivery(Delivery delivery){
        System.out.println(delivery);
        Integer a=service.upd(delivery);
        System.out.println(a);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("delDelivery")
    public boolean delAmendrecord(Delivery delivery){
        Integer a=service.del(delivery);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("getDeliveryOne")
    public Delivery getDeliveryOne(Delivery delivery){
        Delivery deliverys=service.getOne(delivery);
        return deliverys;
    }
    @RequestMapping("/upload")
    public Object uploadaaa(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
        //上传的位置
        //String path =  request.getSession().getServletContext().getRealPath("E:/IdeaProjects/medicalfrontend/static/img/");
        String path;
        //File f = new File("E:/IdeaProjects/medicalfrontend/static/img/");
        //System.out.println("path"+path);
        //判断该路径是否存在
        File file1 = new File("E:/IdeaProjects/medicalfrontend/static/img/");
        if (!file1.exists()) {
            file1.mkdirs();
        }
        //上传文件项
        String filename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String saveName = uuid + "_" + filename.substring(filename.lastIndexOf(File.separator) + 1);
        //file.transferTo(new File(path, saveName));
        uploadImg(file,"E:/IdeaProjects/medicalfrontend/static/img/",saveName);
        return "{\"code\":0,\"msg\":\""+saveName+"\"}";
    }
}
