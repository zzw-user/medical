package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.ClientMapper;
import com.ylht.pojo.Client;
import com.ylht.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientMapper clientMapper;
    public List<Client> getAll() {
        return clientMapper.selectAll();
    }

    public List<Client> getData(Client client) {
        return clientMapper.select(client);
    }

    public Client getOne(Client client) {
        return clientMapper.selectOne(client);
    }

    public Integer add(Client client) {
        return clientMapper.insert(client);
    }

    public Integer del(Client client) {
        return clientMapper.delete(client);
    }

    public Integer upd(Client client) {
        return clientMapper.updateByPrimaryKey(client);
    }

    public PageInfo<Client> getClientAll(String cname, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Client> list =clientMapper.getClientAll(cname);
        PageInfo<Client> pageInfo=new PageInfo<Client>(list);
        return pageInfo;
    }
}
