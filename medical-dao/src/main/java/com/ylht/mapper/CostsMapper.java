package com.ylht.mapper;

import com.ylht.pojo.Cost;
import com.ylht.pojo.Costs;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CostsMapper {
    List<Costs> costselect(@Param("inputtime")Date inputtime,@Param("aftertype")Integer aftertype);
    List<Cost> selectCost(@Param("realname")String realname , @Param("address") String address,@Param("aftertype")Integer aftertype);

}
