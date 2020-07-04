package com.ylht.mapper;

import com.ylht.pojo.Client;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@RequestMapping("ClientMapper")
public interface ClientMapper extends Mapper<Client> {
    List<Client> getClientAll(@Param("cname")String cname,@Param("phone")String phone);
}
