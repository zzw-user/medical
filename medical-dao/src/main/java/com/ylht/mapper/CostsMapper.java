package com.ylht.mapper;

import com.ylht.pojo.Cost;
import com.ylht.pojo.Delivery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CostsMapper {
    List<Cost> selectCost(@Param("realname")String mname , @Param("address") String address);
}
