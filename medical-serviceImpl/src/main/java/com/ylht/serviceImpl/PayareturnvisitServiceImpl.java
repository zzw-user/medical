package com.ylht.serviceImpl;

import com.ylht.mapper.PayareturnvisitMapper;
import com.ylht.pojo.Payareturnvisit;
import com.ylht.service.PayareturnvisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayareturnvisitServiceImpl implements PayareturnvisitService {
    @Autowired
    private PayareturnvisitMapper payareturnvisitMapper;
    public List<Payareturnvisit> getAll() {
        return payareturnvisitMapper.selectAll();
    }

    public List<Payareturnvisit> getData(Payareturnvisit payareturnvisit) {
        return payareturnvisitMapper.select(payareturnvisit);
    }

    public Payareturnvisit getOne(Payareturnvisit payareturnvisit) {
        return payareturnvisitMapper.selectOne(payareturnvisit);
    }

    public Integer add(Payareturnvisit payareturnvisit) {
        return payareturnvisitMapper.insert(payareturnvisit);
    }

    public Integer del(Payareturnvisit payareturnvisit) {
        return payareturnvisitMapper.delete(payareturnvisit);
    }

    public Integer upd(Payareturnvisit payareturnvisit) {
        return payareturnvisitMapper.updateByPrimaryKey(payareturnvisit);
    }
}
