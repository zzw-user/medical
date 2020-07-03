package com.ylht.mapper.xzh;

import com.ylht.pojo.Cost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MaintenancecostsMapper {
    List<Cost> seleCost(@Param("mname") String mname, @Param("address") String address);
}
