package com.ylht.mapper;

import com.ylht.pojo.Cost;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CostMapper extends Mapper<Cost> {
    List<Cost> getCost(Cost cost);
    Cost getCostOne(Cost cost);
}
