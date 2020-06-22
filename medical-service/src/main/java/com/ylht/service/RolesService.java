package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Role;

public interface RolesService {
    PageInfo<Role> getRoleAll(String rname,Integer pageNo, Integer pageSize);
}
