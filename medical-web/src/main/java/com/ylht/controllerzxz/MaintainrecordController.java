package com.ylht.controllerzxz;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.FullMaintainrecord;
import com.ylht.pojo.InstallationRecordEvaluation;
import com.ylht.pojo.Installrecord;
import com.ylht.pojo.Maintainrecord;
import com.ylht.service.MaintainrecordService;
import com.ylht.servicezxz.FullService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/maintainrecordController")
public class MaintainrecordController {
    @Autowired
    private MaintainrecordService maintainrecordService;
    @Autowired
    private FullService fullService;
    public static void uploadImg(MultipartFile file,String path,String name) throws IOException {
        file.transferTo(new File(path,name));

    }
    @RequestMapping("/getFullMaintainrecord")
    public ResultMap<List<FullMaintainrecord>> getFullMaintainrecord(FullMaintainrecord fullMaintainrecord, Integer page, Integer limit){
        PageInfo<FullMaintainrecord> pageInfo = fullService.pageFullMaintainrecord(fullMaintainrecord.getAddress(),fullMaintainrecord.getStatus(),
                fullMaintainrecord.getCoding(),fullMaintainrecord.getRealname(), page, limit);
        return new ResultMap<List<FullMaintainrecord>>("",pageInfo.getList(),0,pageInfo.getTotal());
    }
    @RequestMapping("/deleteMaintainrecordByRid")
    public String deleteMaintainrecordByRid(Maintainrecord maintainrecord){
        int i = maintainrecordService.del(maintainrecord);
        return i>0?"ok":"no";
    }
    @RequestMapping("/addMaintainrecord")
    public String addMaintainrecord(Maintainrecord maintainrecord,String sj) throws ParseException {
        SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd");
        if(sj!=null && sj!=""){
            maintainrecord.setInstallationtime(s.parse(sj));
        }
        int i = maintainrecordService.add(maintainrecord);
        return i>0?"ok":"no";
    }
    @RequestMapping("/getMaintainrecordByRid")
    public Maintainrecord getMaintainrecordByRid(Maintainrecord maintainrecord){
        Maintainrecord maintainrecord1 = maintainrecordService.getOne(maintainrecord);
        return maintainrecord1;
    }
    @RequestMapping("/updateMaintainrecordByRid")
    public String updateMaintainrecordByRid(Maintainrecord maintainrecord,String sj) throws ParseException {
        SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd");
        if(sj!=null && sj!=""){
            maintainrecord.setInstallationtime(s.parse(sj));
        }
        int i = maintainrecordService.upd(maintainrecord);
        return i>0?"ok":"no";
    }
    @RequestMapping("/updateFullMaintainrecordByRid")
    public String updateFullMaintainrecordByRid(Maintainrecord maintainrecord){
        int i = fullService.updateMaintainrecordByRid(maintainrecord);
        return i>0?"ok":"no";
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
