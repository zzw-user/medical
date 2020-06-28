package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.DeliverysMapper;
import com.ylht.pojo.Delivery;
import com.ylht.service.DeliverysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeliverysServiceImpl implements DeliverysService {
    @Autowired
    private DeliverysMapper mapper;
    public PageInfo<Delivery> selectDelivery(String mname, String address, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Delivery> list=mapper.selectDelivery(mname,address);
        PageInfo<Delivery> page=new PageInfo<Delivery>(list);
        return page;
    }
}
