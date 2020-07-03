package com.ylht.serviceImpl;

import com.ylht.mapper.AmendrecordMapper;
import com.ylht.pojo.Amendrecord;
import com.ylht.service.AmendrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmendrecordServiceImpl implements AmendrecordService {
    @Autowired
    private AmendrecordMapper amendrecordMapper;
    public List<Amendrecord> getAll() {
        return amendrecordMapper.selectAll();
    }

    public List<Amendrecord> getData(Amendrecord amendrecord) {
        return amendrecordMapper.select(amendrecord);
    }

    public Amendrecord getOne(Amendrecord amendrecord) {
        return amendrecordMapper.selectOne(amendrecord);
    }

    public Integer add(Amendrecord amendrecord) {
        return amendrecordMapper.insert(amendrecord);
    }

    public Integer del(Amendrecord amendrecord) {
        return amendrecordMapper.delete(amendrecord);
    }

    public Integer upd(Amendrecord amendrecord) {
        return amendrecordMapper.updateByPrimaryKeySelective(amendrecord);
    }

    public List<Amendrecord> getRecord(Amendrecord amendrecord) {
        return amendrecordMapper.getRecord(amendrecord);
    }

    public Amendrecord getRecordOne(Amendrecord amendrecord) {
        return amendrecordMapper.getRecordOne(amendrecord);
    }
}
