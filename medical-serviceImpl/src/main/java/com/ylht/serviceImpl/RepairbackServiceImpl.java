package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.xzh.RepairbackMapper;
import com.ylht.pojo.Payareturnvisits;
import com.ylht.pojo.Warehouses;
import com.ylht.service.RepairbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairbackServiceImpl implements RepairbackService {
    @Autowired
    private RepairbackMapper mapper;

    public PageInfo<Payareturnvisits> selePayareturnvisit(String pname, String way,Integer aftertype,Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Payareturnvisits> list=mapper.selePayareturnvisit(pname,way,aftertype);
        PageInfo<Payareturnvisits> page=new PageInfo<Payareturnvisits>(list);
        return page;
    }
}
