package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.xzh.RepairbackMapper;
import com.ylht.pojo.Payareturnvisit;
import com.ylht.service.RepairbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairbackServiceImpl implements RepairbackService {
    @Autowired
    private RepairbackMapper mapper;

    public PageInfo<Payareturnvisit> selePayareturnvisit(String pname, String way, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Payareturnvisit> list=mapper.selePayareturnvisit(pname,way);
        PageInfo<Payareturnvisit> page=new PageInfo<Payareturnvisit>(list);
        return page;
    }
}
