package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.RolesMapper;
import com.ylht.pojo.Role;
import com.ylht.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceimpl  implements RolesService {
    @Autowired
    private RolesMapper rolesMapper;
    public PageInfo<Role> getRoleAll(String rname, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Role> list =rolesMapper.getRoleAll(rname);
        PageInfo<Role> page=new PageInfo<Role>(list);
        return page;
    }
}
