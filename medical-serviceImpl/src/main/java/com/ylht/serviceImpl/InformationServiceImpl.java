package com.ylht.serviceImpl;

import com.ylht.mapper.InformationMapper;
import com.ylht.pojo.Information;
import com.ylht.service.InformationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;

    public InformationServiceImpl() {
    }

    public List<Information> getAll() {
        return this.informationMapper.selectAll();
    }

    public List<Information> getData(Information information) {
        return this.informationMapper.select(information);
    }

    public Information getOne(Information information) {
        return (Information)this.informationMapper.selectOne(information);
    }

    public Integer add(Information information) {
        return this.informationMapper.insert(information);
    }

    public Integer del(Information information) {
        return this.informationMapper.deleteByPrimaryKey(information);
    }

    public Integer upd(Information information) {
        return this.informationMapper.updateByPrimaryKeySelective(information);
    }

    public List<Information> selectNotXitong(Information information) {
        return this.informationMapper.selectNotXitong(information);
    }

    public int updateIsread(Information information) {
        return this.informationMapper.updateIsread(information);
    }
}
