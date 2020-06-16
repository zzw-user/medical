package com.ylht.serviceImpl;

import com.ylht.mapper.DeliveryMapper;
import com.ylht.pojo.Delivery;
import com.ylht.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryMapper deliveryMapper;
    public List<Delivery> getAll() {
        return deliveryMapper.selectAll();
    }

    public List<Delivery> getData(Delivery delivery) {
        return deliveryMapper.select(delivery);
    }

    public Delivery getOne(Delivery delivery) {
        return deliveryMapper.selectOne(delivery);
    }

    public Integer add(Delivery delivery) {
        return deliveryMapper.insert(delivery);
    }

    public Integer del(Delivery delivery) {
        return deliveryMapper.delete(delivery);
    }

    public Integer upd(Delivery delivery) {
        return deliveryMapper.updateByPrimaryKey(delivery);
    }
}
