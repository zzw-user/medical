package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Cost;

public interface MaintenancecostsServic {
    PageInfo<Cost> seleCost(String mname , String address, Integer pageNo, Integer pageSize);
}
