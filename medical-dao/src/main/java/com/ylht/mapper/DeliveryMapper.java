package com.ylht.mapper;

import com.ylht.pojo.Delivery;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DeliveryMapper extends Mapper<Delivery> {
    List<Delivery> getDelivery(Delivery delivery);
    Delivery getDeliveryOne(Delivery delivery);
}
