package com.ylht.service;

import com.ylht.pojo.Cost;

import java.util.List;

public interface CostService extends DataService<Cost>{
    List<Cost> getCost(Cost cost);
    Cost getCostOne(Cost cost);
}
