package com.ylht.serviceImpl;

import com.ylht.mapper.InstallrecordMapper;
import com.ylht.pojo.Installrecord;
import com.ylht.service.InstallrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstallrecordServiceImpl implements InstallrecordService {
    @Autowired
    private InstallrecordMapper installrecordMapper;
    public List<Installrecord> getAll() {
        return installrecordMapper.selectAll();
    }

    public List<Installrecord> getData(Installrecord installrecord) {
        return installrecordMapper.select(installrecord);
    }

    public Installrecord getOne(Installrecord installrecord) {
        return installrecordMapper.selectOne(installrecord);
    }

    public Integer add(Installrecord installrecord) {
        return installrecordMapper.insert(installrecord);
    }

    public Integer del(Installrecord installrecord) {
        return installrecordMapper.delete(installrecord);
    }

    public Integer upd(Installrecord installrecord) {
        return installrecordMapper.updateByPrimaryKey(installrecord);
    }

    public List<Installrecord> getRecord(Installrecord installrecord) {
        return installrecordMapper.getRecord(installrecord);
    }

    public Installrecord getRecordOne(Installrecord installrecord) {
        return installrecordMapper.getRecordOne(installrecord);
    }
}
