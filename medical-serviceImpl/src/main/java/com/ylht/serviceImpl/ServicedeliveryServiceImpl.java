package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.xzh.ServicedeliveryMapper;
import com.ylht.pojo.Delivery;
import com.ylht.service.ServicedeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicedeliveryServiceImpl implements ServicedeliveryService {
    @Autowired
    private ServicedeliveryMapper mapper;


    public PageInfo<Delivery> seleDelivery(String mname, String address, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Delivery> list=mapper.seleDelivery(mname,address);
        PageInfo<Delivery> page=new PageInfo<Delivery>(list);
        return page;
    }
}
