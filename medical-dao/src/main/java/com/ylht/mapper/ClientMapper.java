package com.ylht.mapper;

import com.ylht.pojo.Client;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.common.Mapper;
@RequestMapping("ClientMapper")
public interface ClientMapper extends Mapper<Client> {
}
