package com.ylht.service;

import com.ylht.pojo.Delivery;

import java.util.List;

public interface DeliveryService extends DataService<Delivery> {
    List<Delivery> getDelivery(Delivery delivery);
    Delivery getDeliveryOne(Delivery delivery);
}
