package com.ylht.controller.cjh;

import com.ylht.pojo.Role;
import com.ylht.service.RoleService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("getRole")
    public ResultMap<List<Role>> getRole(Role role){
        List<Role> list=roleService.getData(role);
        return  new ResultMap<List<Role>>("",list,0,list.size());
    }

    @RequestMapping("addRole")
    public boolean addRole(Role role){
        int result=roleService.add(role);
        if (result>0){
            return true;
        }
        return  false;
    }
    @RequestMapping("updateRole")
    public boolean updRole(Role role){
        int result=roleService.upd(role);
        if (result>0){
            return true;
        }
        return  false;
    }

    @RequestMapping("delRole")
    public boolean delRole(Role role){
        int result=roleService.del(role);
        if (result>0){
            return true;
        }
        return  false;
    }
}
