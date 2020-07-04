package com.ylht.serviceImpl;

import com.ylht.mapper.ProducttypeMapper;
import com.ylht.pojo.Producttype;
import com.ylht.service.ProducttypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducttypeServiceImpl implements ProducttypeService {
    @Autowired
    private ProducttypeMapper producttypeMapper;

    public List<Producttype> getAll() {
        return producttypeMapper.selectAll();
    }

    public List<Producttype> getData(Producttype producttype) {
        return producttypeMapper.select(producttype);
    }

    public Producttype getOne(Producttype producttype) {
        return producttypeMapper.selectOne(producttype);
    }

    public Integer add(Producttype producttype) {
        return producttypeMapper.insert(producttype);
    }

    public Integer del(Producttype producttype) {
        return producttypeMapper.delete(producttype);
    }

    public Integer upd(Producttype producttype) {
        return producttypeMapper.updateByPrimaryKey(producttype);
    }
}
