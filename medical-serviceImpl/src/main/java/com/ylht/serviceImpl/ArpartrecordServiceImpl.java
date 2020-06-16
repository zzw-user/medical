package com.ylht.serviceImpl;

import com.ylht.mapper.ArpartrecordMapper;
import com.ylht.pojo.Arpartrecord;
import com.ylht.service.ArpartrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArpartrecordServiceImpl implements ArpartrecordService {
    @Autowired
    private ArpartrecordMapper arpartrecordMapper;
    public List<Arpartrecord> getAll() {
        return arpartrecordMapper.selectAll();
    }

    public List<Arpartrecord> getData(Arpartrecord arpartrecord) {
        return arpartrecordMapper.select(arpartrecord);
    }

    public Arpartrecord getOne(Arpartrecord arpartrecord) {
        return arpartrecordMapper.selectOne(arpartrecord);
    }

    public Integer add(Arpartrecord arpartrecord) {
        return arpartrecordMapper.insert(arpartrecord);
    }

    public Integer del(Arpartrecord arpartrecord) {
        return arpartrecordMapper.delete(arpartrecord);
    }

    public Integer upd(Arpartrecord arpartrecord) {
        return arpartrecordMapper.updateByPrimaryKey(arpartrecord);
    }
}
