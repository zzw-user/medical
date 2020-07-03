package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.xzh.MaintenancerecordMapper;
import com.ylht.pojo.Amendrecord;
import com.ylht.pojo.InstallationRecordEvaluation;
import com.ylht.service.MaintenancerecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenancerecordServiceImpl implements MaintenancerecordService {
    @Autowired
    private MaintenancerecordMapper mapper;

    public PageInfo<Amendrecord> seleAmendrecord(String address, Integer status, String productcoding, String realname, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Amendrecord> list = mapper.seleAmendrecord(address, status, productcoding, realname);
        PageInfo<Amendrecord> pageInfo = new PageInfo<Amendrecord>(list);
        return pageInfo;
    }
}
