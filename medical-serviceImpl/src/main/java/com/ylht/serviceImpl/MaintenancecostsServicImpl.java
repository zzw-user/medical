package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.xzh.MaintenancecostsMapper;
import com.ylht.pojo.Cost;
import com.ylht.service.MaintenancecostsServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenancecostsServicImpl implements MaintenancecostsServic {
    @Autowired
    public MaintenancecostsMapper mapper;


    public PageInfo<Cost> seleCost(String mname, String address, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Cost> list=mapper.seleCost(mname,address);
        PageInfo<Cost> page=new PageInfo<Cost>(list);
        return page;
    }
}
