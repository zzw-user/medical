package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Client;

public interface ClientService  extends DataService<Client>{
    PageInfo<Client> getClientAll(String cname,String phone, Integer pageNo, Integer pageSize);
}
