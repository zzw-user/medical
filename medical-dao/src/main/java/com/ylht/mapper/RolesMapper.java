package com.ylht.mapper;

import com.ylht.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("rolesMapper")
public interface RolesMapper {
    List<Role> getRoleAll(@Param("rname")String rname);
}
