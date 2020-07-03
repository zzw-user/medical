package com.ylht.mapperzxz;

import com.ylht.pojo.InstallationRecordEvaluation;
import com.ylht.pojo.Installrecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface InstallationRecordEvaluationMapper {
    List<InstallationRecordEvaluation> getInstallationRecordEvaluation(@Param("address") String address, @Param("status") Integer status,
                                                                       @Param("coding") String coding, @Param("realname") String realname,
                                                                       @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
    int updateInstallrecordByRid(Installrecord installrecord);
}
