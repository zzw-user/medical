package com.ylht.controller.cjh;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Client;
import com.ylht.pojo.Mpuser;
import com.ylht.pojo.Role;
import com.ylht.service.ClientService;
import com.ylht.service.ClientsService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientsService clientsService;

    @RequestMapping("getClientALL")
    public ResultMap<List<Client>> getRoles(String cname, Integer page, Integer limit){
        PageInfo<Client> pages=clientsService.getClientAll(cname,page,limit);
        return  new ResultMap<List<Client>>("",pages.getList(),0,pages.getTotal());
    }

    @RequestMapping("getClient")
    public ResultMap<List<Client>> getRole(Client client){
        List<Client> list=clientService.getData(client);
        return  new ResultMap<List<Client>>("",list,0,list.size());
    }

    @RequestMapping("addClient")
    public boolean addRole(Client client){
        int result=clientService.add(client);
        if (result>0){
            return true;
        }
        return  false;
    }
    @RequestMapping("updateClient")
    public boolean updRole(Client client){
        int result=clientService.upd(client);
        if (result>0){
            return true;
        }
        return  false;
    }

    @RequestMapping("delClient")
    public boolean delRole(Client client){
        int result=clientService.del(client);
        if (result>0){
            return true;
        }
        return  false;
    }

    @RequestMapping("getClientOne")
    public Client get(Client client){
        Client clients=clientService.getOne(client);
        return clients;
    }
}
