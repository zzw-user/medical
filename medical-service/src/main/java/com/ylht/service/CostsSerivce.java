package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Cost;
import com.ylht.pojo.Delivery;
import org.apache.ibatis.annotations.Param;

public interface CostsSerivce {
    PageInfo<Cost> selectCost(String realname , String address,Integer aftertype, Integer pageNo, Integer pageSize);
}
