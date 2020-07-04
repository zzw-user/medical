package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.FaultanalysisMapper;
import com.ylht.pojo.Areafaultanalysis;
import com.ylht.pojo.Arparts;
import com.ylht.pojo.Faultanalysis;
import com.ylht.service.FaultanalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FaultanalysisServiceImpl implements FaultanalysisService {
    @Autowired
    private FaultanalysisMapper faultanalysisMapper;

    public PageInfo<Faultanalysis> selectfau(Integer pageNum, Integer pageSize, Integer id, Date installationtime) {
        PageHelper.startPage(pageNum,pageSize);
        List<Faultanalysis> list=faultanalysisMapper.selectfau(id, installationtime);
        PageInfo<Faultanalysis> page=new PageInfo<Faultanalysis>(list);

        return page;
    }

    public int delOne(Integer fid) {
        return faultanalysisMapper.delOne(fid);
    }


    public Faultanalysis selectOne(Integer fid) {
        return faultanalysisMapper.selectOne(fid);
    }

    public int uodfau(Faultanalysis faultanalysis) {
        return faultanalysisMapper.uodfau(faultanalysis);
    }

    public int addFau(Faultanalysis faultanalysis) {
        return faultanalysisMapper.addFau(faultanalysis);
    }

    public PageInfo<Areafaultanalysis> areaselectfau(Integer pageNum, Integer pageSize, Integer id, Date installationtime, Integer did) {
        PageHelper.startPage(pageNum,pageSize);
        List<Areafaultanalysis> list=faultanalysisMapper.areaselectfau(id, installationtime,did);
        PageInfo<Areafaultanalysis> page=new PageInfo<Areafaultanalysis>(list);

        return page;
    }
}
