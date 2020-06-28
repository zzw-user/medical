package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Delivery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliverysService {
    PageInfo<Delivery> selectDelivery(String mname , String address, Integer pageNo, Integer pageSize);
}
