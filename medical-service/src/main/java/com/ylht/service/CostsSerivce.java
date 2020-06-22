package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Cost;
import com.ylht.pojo.Delivery;

public interface CostsSerivce {
    PageInfo<Cost> selectCost(String mname , String address, Integer pageNo, Integer pageSize);
}
