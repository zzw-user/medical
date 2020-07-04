package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Costs;

import java.util.Date;

public interface CostsService {
    PageInfo<Costs> costspage(Integer pageNum, Integer pageSize,Date inputtime,Integer aftertype);
}
