package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Amendrecord;
import com.ylht.pojo.InstallationRecordEvaluation;
import org.apache.ibatis.annotations.Param;

public interface MaintenancerecordService {

    PageInfo<Amendrecord> seleAmendrecord(String address, Integer status, String productcoding, String realname, Integer pageNo, Integer pageSize);
}
