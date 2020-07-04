package com.ylht.mapper;

import com.ylht.pojo.Role;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {
    List<Role> getRoleAll(@Param("rname")String rname,@Param("hierarchy")Integer hierarchy);

}
