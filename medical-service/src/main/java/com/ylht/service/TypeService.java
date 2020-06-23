package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Type;

public interface TypeService extends DataService<Type> {
    PageInfo<Type> getshow(String tname, Integer pageNo, Integer pageSize);

}
