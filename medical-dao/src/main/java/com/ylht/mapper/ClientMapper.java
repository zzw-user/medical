package com.ylht.mapper;

import com.ylht.pojo.Client;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ClientMapper extends Mapper<Client> {
    List<Client> getClientAll(@Param("cname")String cname);
}
