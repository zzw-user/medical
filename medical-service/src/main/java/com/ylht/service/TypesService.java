package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Type;

public interface TypesService {
    PageInfo<Type> getshow(String tname,Integer pageNo, Integer pageSize);
}
