package com.ylht.serviceImpl;

import com.ylht.mapper.CostMapper;
import com.ylht.pojo.Cost;
import com.ylht.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostServiceImpl implements CostService {
    @Autowired
    private CostMapper costMapper;
    public List<Cost> getAll() {
        return costMapper.selectAll();
    }

    public List<Cost> getData(Cost cost) {
        return costMapper.select(cost);
    }

    public Cost getOne(Cost cost) {
        return costMapper.selectOne(cost);
    }

    public Integer add(Cost cost) {
        return costMapper.insert(cost);
    }

    public Integer del(Cost cost) {
        return costMapper.delete(cost);
    }

    public Integer upd(Cost cost) {
        return costMapper.updateByPrimaryKeySelective(cost);
    }

    public List<Cost> getCost(Cost cost) {
        return costMapper.getCost(cost);
    }

    public Cost getCostOne(Cost cost) {
        return costMapper.getCostOne(cost);
    }
}
