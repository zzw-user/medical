package com.ylht.liujiancontroller;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.*;
import com.ylht.service.AmendrecordService;
import com.ylht.service.DistrictService;
import com.ylht.service.FaultanalysisService;
import com.ylht.service.FaulttypeService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class FaultanalysisController {
    @Autowired
    private FaultanalysisService faultanalysisService;
    @Autowired
    private FaulttypeService faulttypeService;
    @Autowired
    private AmendrecordService amendrecordService;
    @Autowired
    private DistrictService districtService;
    @RequestMapping("selectfau")
    public Object selectfau(Integer page, Integer limit, Integer id, String installationtime) throws ParseException {
        Date insdate=null;
        if(installationtime!=null && installationtime!=""){
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            insdate =  s.parse(installationtime);
        }
        PageInfo<Faultanalysis> pageinfo=faultanalysisService.selectfau(page,limit,id,insdate);
        ResultMap<List<Faultanalysis>> resultMap = new ResultMap<List<Faultanalysis>>("",pageinfo.getList(),0,pageinfo.getTotal());
        return resultMap;
    }
    @RequestMapping("allFaulttype")
    public Object allFaulttype(){
        List<Faulttype> list=faulttypeService.getAll();
        return list;

    }
    @RequestMapping("panduan")
    public Object panduan(Amendrecord amendrecord){
        Amendrecord amendrecord1=amendrecordService.getOne(amendrecord);
        if(amendrecord1!=null){
            return "true";
        }
        return "false";
    }
    @RequestMapping("delOne")
    public Object delOne(Integer fid){
        int i = faultanalysisService.delOne(fid);
        if (i>0){
            return "true";
        }
        return "false";
    }
    @RequestMapping("selectOneFau")
    public Object selectOne(Integer fid){
        Faultanalysis faultanalysis=faultanalysisService.selectOne(fid);
        return faultanalysis;
    }
    @RequestMapping("updFau")
    public Object updFau(Faultanalysis faultanalysis){
        int i =faultanalysisService.uodfau(faultanalysis);
        if (i>0){
            return "true";
        }
        return "false";
    }
    @RequestMapping("addFau")
    public Object addFau(Faultanalysis faultanalysis){
        int i=faultanalysisService.addFau(faultanalysis);
        if (i>0){
            return "true";
        }
        return "false";
    }
    @RequestMapping("areaselectfau")
    public Object areaselectfau(Integer page, Integer limit, Integer id, String installationtime,Integer did) throws ParseException {
        Date insdate=null;
        if(installationtime!=null && installationtime!=""){
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            insdate =  s.parse(installationtime);
        }
        PageInfo<Areafaultanalysis> pageinfo=faultanalysisService.areaselectfau(page,limit,id,insdate,did);
        ResultMap<List<Areafaultanalysis>> resultMap = new ResultMap<List<Areafaultanalysis>>("",pageinfo.getList(),0,pageinfo.getTotal());
        return resultMap;
    }
    @RequestMapping("selectdistrict")
    public  Object selectdistrict(){
        List<District> list=districtService.getAll();
        return list;
    }
}
