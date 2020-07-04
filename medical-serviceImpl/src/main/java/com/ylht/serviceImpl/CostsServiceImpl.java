package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.CostsMapper;
import com.ylht.pojo.Cost;
import com.ylht.pojo.Costs;
import com.ylht.service.CostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CostsServiceImpl implements CostsService {
    @Autowired
    private CostsMapper costsMapper;

    public PageInfo<Costs> costspage(Integer pageNum, Integer pageSize, Date inputtime, Integer aftertype) {
        PageHelper.startPage(pageNum,pageSize);
        List<Costs> list=costsMapper.costselect(inputtime,aftertype);
        PageInfo<Costs> page=new PageInfo<Costs>(list);
        return page;
    }
}
