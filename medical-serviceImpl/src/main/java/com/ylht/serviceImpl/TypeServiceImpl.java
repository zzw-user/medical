package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.TypeMapper;
import com.ylht.pojo.Type;
import com.ylht.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    public List<Type> getAll() {
        return typeMapper.selectAll();
    }

    public List<Type> getData(Type type) {
        return typeMapper.select(type);
    }

    public Type getOne(Type type) {
        return typeMapper.selectOne(type);
    }

    public Integer add(Type type) {
        return typeMapper.insert(type);
    }

    public Integer del(Type type) {
        return typeMapper.delete(type);
    }

    public Integer upd(Type type) {
        return typeMapper.updateByPrimaryKey(type);
    }

    public PageInfo<Type> getshow(String tname, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Type>  list=typeMapper.getTypeAll(tname);
        PageInfo<Type> pageInfo=new PageInfo<Type>(list);
        return pageInfo;
    }
}
