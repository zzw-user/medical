package com.ylht.mapper.xzh;

import com.ylht.pojo.Amendrecord;
import com.ylht.pojo.InstallationRecordEvaluation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MaintenancerecordMapper {
    List<Amendrecord> seleAmendrecord(@Param("address") String address, @Param("status") Integer status,@Param("productcoding") String productcoding, @Param("realname") String realname);
}
