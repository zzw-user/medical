package com.ylht.serviceImpl;

import com.ylht.mapper.FaulttypeMapper;
import com.ylht.pojo.Faulttype;
import com.ylht.service.FaulttypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FaulttypeServiceImpl implements FaulttypeService {
    @Autowired
    private FaulttypeMapper faulttypeMapper;
    public List<Faulttype> getAll() {
        return faulttypeMapper.selectAll();
    }

    public List<Faulttype> getData(Faulttype faulttype) {
        return faulttypeMapper.select(faulttype);
    }

    public Faulttype getOne(Faulttype faulttype) {
        return faulttypeMapper.selectOne(faulttype);
    }

    public Integer add(Faulttype faulttype) {
        return faulttypeMapper.insert(faulttype);
    }

    public Integer del(Faulttype faulttype) {
        return faulttypeMapper.delete(faulttype);
    }

    public Integer upd(Faulttype faulttype) {
        return faulttypeMapper.updateByPrimaryKey(faulttype);
    }
}
