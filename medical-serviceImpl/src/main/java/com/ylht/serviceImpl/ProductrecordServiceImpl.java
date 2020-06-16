package com.ylht.serviceImpl;

import com.ylht.mapper.ProductrecordMapper;
import com.ylht.pojo.Productrecord;
import com.ylht.service.ProductrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductrecordServiceImpl implements ProductrecordService {
    @Autowired
    private ProductrecordMapper productrecordMapper;
    public List<Productrecord> getAll() {
        return productrecordMapper.selectAll();
    }

    public List<Productrecord> getData(Productrecord productrecord) {
        return productrecordMapper.select(productrecord);
    }

    public Productrecord getOne(Productrecord productrecord) {
        return productrecordMapper.selectOne(productrecord);
    }

    public Integer add(Productrecord productrecord) {
        return productrecordMapper.insert(productrecord);
    }

    public Integer del(Productrecord productrecord) {
        return productrecordMapper.delete(productrecord);
    }

    public Integer upd(Productrecord productrecord) {
        return productrecordMapper.updateByPrimaryKey(productrecord);
    }
}
