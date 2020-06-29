package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Delivery;

public interface ServicedeliveryService {
    PageInfo<Delivery> seleDelivery(String mname , String address, Integer pageNo, Integer pageSize);
}
