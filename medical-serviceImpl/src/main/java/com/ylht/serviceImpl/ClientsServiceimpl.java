package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.ClientsMapper;
import com.ylht.pojo.Client;
import com.ylht.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsServiceimpl implements ClientsService {
    @Autowired
    private ClientsMapper clientsMapper;
    public PageInfo<Client> getClientAll(String cname, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Client> list =clientsMapper.getClientAll(cname);
        PageInfo<Client> pageInfo=new PageInfo<Client>(list);
        return pageInfo;
    }
}
