package com.ylht.serviceImpl;

import com.ylht.mapper.ArpartMapper;
import com.ylht.pojo.Arpart;
import com.ylht.service.ArpartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArpartServiceImpl implements ArpartService {
    @Autowired
    private ArpartMapper arpartMapper;
    public List<Arpart> getAll() {
        return arpartMapper.selectAll();
    }

    public List<Arpart> getData(Arpart arpart) {
        return arpartMapper.select(arpart);
    }

    public Arpart getOne(Arpart arpart) {
        return arpartMapper.selectOne(arpart);
    }

    public Integer add(Arpart arpart) {
        return arpartMapper.insert(arpart);
    }

    public Integer del(Arpart arpart) {
        return arpartMapper.delete(arpart);
    }

    public Integer upd(Arpart arpart) {
        return arpartMapper.updateByPrimaryKey(arpart);
    }
}
