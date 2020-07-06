package com.ylht.controllerzxz;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.InstallationRecordEvaluation;
import com.ylht.pojo.Installrecord;
import com.ylht.pojo.Type;
import com.ylht.service.InstallrecordService;
import com.ylht.service.TypeService;
import com.ylht.servicezxz.InstallationRecordEvaluationService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/InstallationRecordEvaluation")
public class InstallationRecordEvaluationController {
    @Autowired
    private InstallationRecordEvaluationService installationRecordEvaluationService;
    @Autowired
    private InstallrecordService installrecordService;
    @Autowired
    private TypeService typeService;
    public static void uploadImg(MultipartFile file,String path,String name) throws IOException {
        file.transferTo(new File(path,name));

    }

    @RequestMapping("/getType")
    public List<Type> getType(){
        List<Type> list = typeService.getAll();
        return list;
    }

    @RequestMapping("/getInstallationRecordEvaluation")
    public ResultMap<List<InstallationRecordEvaluation>> getInstallationRecordEvaluation(InstallationRecordEvaluation installationRecordEvaluation, Integer page, Integer limit){
        PageInfo<InstallationRecordEvaluation> pageInfo = installationRecordEvaluationService.pageInstallationRecordEvaluation(installationRecordEvaluation.getAddress(),installationRecordEvaluation.getStatus(),
                installationRecordEvaluation.getCoding(),installationRecordEvaluation.getRealname(), page, limit);
        return new ResultMap<List<InstallationRecordEvaluation>>("",pageInfo.getList(),0,pageInfo.getTotal());
    }
    @RequestMapping("/deleteInstallationRecordEvaluationByRid")
    public String deleteInstallationRecordEvaluationByRid(Installrecord installrecord){
        int i = installrecordService.del(installrecord);
        return i>0?"ok":"no";
    }
    @RequestMapping("/addInstallationRecordEvaluation")
    public String addInstallationRecordEvaluation(Installrecord installrecord,String sj) throws ParseException {
        SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd");
        if(sj!=null && sj!=""){
            installrecord.setInstallationtime(s.parse(sj));
        }
        int i = installrecordService.add(installrecord);
        return i>0?"ok":"no";
    }
    @RequestMapping("/getInstallationRecordEvaluationByRid")
    public Installrecord getInstallationRecordEvaluationByRid(Installrecord installrecord){
        Installrecord installrecord1 = installrecordService.getOne(installrecord);
        return installrecord1;
    }
    @RequestMapping("/updateInstallationRecordEvaluationByRid")
    public String updateInstallationRecordEvaluationByRid(Installrecord installrecord,String sj) throws ParseException {
        SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd");
        if(sj!=null && sj!=""){
            installrecord.setInstallationtime(s.parse(sj));
        }
        int i = installrecordService.upd(installrecord);
        return i>0?"ok":"no";
    }
    @RequestMapping("/updateInstallrecordByRid")
    public String updateInstallrecordByRid(Installrecord installrecord){
        int i = installationRecordEvaluationService.updateInstallrecordByRid(installrecord);
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
        File file1 = new File("D:/medicalfrontend/static/img/");
        if (!file1.exists()) {
            file1.mkdirs();
        }
        //上传文件项
        String filename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String saveName = uuid + "_" + filename.substring(filename.lastIndexOf(File.separator) + 1);
        //file.transferTo(new File(path, saveName));
        uploadImg(file,"D:/medicalfrontend/static/img/",saveName);
        return "{\"code\":0,\"msg\":\""+saveName+"\"}";
    }
}
