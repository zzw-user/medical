package com.ylht.mapper;

import com.ylht.pojo.Client;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientsMapper {
    List<Client> getClientAll(@Param("cname")String cname);
}
