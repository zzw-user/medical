package com.ylht.mapper.xzh;

import com.ylht.pojo.Cost;
import com.ylht.pojo.Costs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MaintenancecostsMapper {
    List<Costs> seleCost(@Param("mname") String mname, @Param("address") String address);
}
