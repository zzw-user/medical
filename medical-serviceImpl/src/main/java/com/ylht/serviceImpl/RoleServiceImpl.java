package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.RoleMapper;
import com.ylht.pojo.Role;
import com.ylht.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    public List<Role> getAll() {
        return roleMapper.selectAll();
    }

    public List<Role> getData(Role role) {
        return roleMapper.select(role);
    }

    public Role getOne(Role role) {
        return roleMapper.selectOne(role);
    }

    public Integer add(Role role) {
        return roleMapper.insert(role);
    }

    public Integer del(Role role) {
        return roleMapper.delete(role);
    }

    public Integer upd(Role role) {
        return roleMapper.updateByPrimaryKey(role);
    }

    public PageInfo<Role> getRoleAll(String rname, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Role> list =roleMapper.getRoleAll(rname);
        PageInfo<Role> page=new PageInfo<Role>(list);
        return page;
    }
}
