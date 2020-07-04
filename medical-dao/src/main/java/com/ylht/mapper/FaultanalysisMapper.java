package com.ylht.mapper;

import com.ylht.pojo.Areafaultanalysis;
import com.ylht.pojo.Faultanalysis;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface FaultanalysisMapper {
    List<Faultanalysis> selectfau(@Param("id")Integer id,@Param("installationtime") Date installationtime);
    int delOne(Integer fid);
    Faultanalysis selectOne(Integer fid);
    int uodfau(Faultanalysis faultanalysis);
    int addFau(Faultanalysis faultanalysis);
    List<Areafaultanalysis> areaselectfau(@Param("id")Integer id, @Param("installationtime") Date installationtime, @Param("did")Integer did);

}
