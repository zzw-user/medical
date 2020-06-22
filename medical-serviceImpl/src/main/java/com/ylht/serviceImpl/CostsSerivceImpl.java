package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.CostsMapper;
import com.ylht.pojo.Cost;
import com.ylht.pojo.Delivery;
import com.ylht.service.CostsSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostsSerivceImpl implements CostsSerivce {
    @Autowired
    private CostsMapper costsMapper;

    public PageInfo<Cost> selectCost(String mname, String address, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Cost> list=costsMapper.selectCost(mname,address);
        PageInfo<Cost> page=new PageInfo<Cost>(list);
        return page;
    }
}
