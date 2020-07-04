package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Areafaultanalysis;
import com.ylht.pojo.Faultanalysis;

import java.util.Date;

public interface FaultanalysisService {
    PageInfo<Faultanalysis> selectfau(Integer pageNum, Integer pageSize, Integer id, Date installationtime);
    int delOne(Integer fid);
    Faultanalysis selectOne(Integer fid);
    int uodfau(Faultanalysis faultanalysis);
    int addFau(Faultanalysis faultanalysis);
    PageInfo<Areafaultanalysis> areaselectfau(Integer pageNum, Integer pageSize, Integer id, Date installationtime, Integer did);

}
