package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.TypesMapper;
import com.ylht.pojo.Type;
import com.ylht.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypesServiceimpl implements TypesService {
    @Autowired
    private TypesMapper typesMapper;

    public PageInfo<Type> getshow(String tname, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Type>  list=typesMapper.getTypeAll(tname);
        PageInfo<Type> pageInfo=new PageInfo<Type>(list);
        return pageInfo;
    }
}
