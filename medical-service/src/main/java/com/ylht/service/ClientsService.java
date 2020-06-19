package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Client;

public interface ClientsService {
    PageInfo<Client> getClientAll(String cname,Integer pageNo, Integer pageSize);
}
