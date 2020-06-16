package com.ylht.serviceImpl;

import com.ylht.mapper.MaintainrecordMapper;
import com.ylht.pojo.Maintainrecord;
import com.ylht.service.MaintainrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintainrecordServiceImpl implements MaintainrecordService {
    @Autowired
    private MaintainrecordMapper maintainrecordMapper;
    public List<Maintainrecord> getAll() {
        return maintainrecordMapper.selectAll();
    }

    public List<Maintainrecord> getData(Maintainrecord maintainrecord) {
        return maintainrecordMapper.select(maintainrecord);
    }

    public Maintainrecord getOne(Maintainrecord maintainrecord) {
        return maintainrecordMapper.selectOne(maintainrecord);
    }

    public Integer add(Maintainrecord maintainrecord) {
        return maintainrecordMapper.insert(maintainrecord);
    }

    public Integer del(Maintainrecord maintainrecord) {
        return maintainrecordMapper.delete(maintainrecord);
    }

    public Integer upd(Maintainrecord maintainrecord) {
        return maintainrecordMapper.updateByPrimaryKey(maintainrecord);
    }
}
