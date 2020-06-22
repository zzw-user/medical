package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Role;

public interface RoleService extends DataService<Role> {
    PageInfo<Role> getRoleAll(String rname, Integer pageNo, Integer pageSize);

}
