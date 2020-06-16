package com.ylht.serviceImpl;

import com.ylht.mapper.OrderformMapper;
import com.ylht.pojo.Orderform;
import com.ylht.service.OrderformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderformServiceImpl implements OrderformService {
    @Autowired
    private OrderformMapper orderformMapper;
    public List<Orderform> getAll() {
        return orderformMapper.selectAll();
    }

    public List<Orderform> getData(Orderform orderform) {
        return orderformMapper.select(orderform);
    }

    public Orderform getOne(Orderform orderform) {
        return orderformMapper.selectOne(orderform);
    }

    public Integer add(Orderform orderform) {
        return orderformMapper.insert(orderform);
    }

    public Integer del(Orderform orderform) {
        return orderformMapper.delete(orderform);
    }

    public Integer upd(Orderform orderform) {
        return orderformMapper.updateByPrimaryKey(orderform);
    }
}
