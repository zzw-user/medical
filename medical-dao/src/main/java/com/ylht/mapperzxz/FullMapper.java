package com.ylht.mapperzxz;

import com.ylht.pojo.FullMaintainrecord;
import com.ylht.pojo.InstallationRecordEvaluation;
import com.ylht.pojo.Installrecord;
import com.ylht.pojo.Maintainrecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FullMapper {
    List<FullMaintainrecord> getFull(@Param("address") String address, @Param("status") Integer status,
                                     @Param("coding") String coding, @Param("realname") String realname);
    int updateMaintainrecordByRid(Maintainrecord maintainrecord);
}
