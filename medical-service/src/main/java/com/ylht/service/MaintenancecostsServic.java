package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Cost;
import com.ylht.pojo.Costs;

public interface MaintenancecostsServic {
    PageInfo<Costs> seleCost(String mname , String address, Integer pageNo, Integer pageSize);
}
