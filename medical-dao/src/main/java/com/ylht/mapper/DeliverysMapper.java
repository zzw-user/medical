package com.ylht.mapper;

import com.ylht.pojo.Delivery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DeliverysMapper {
    List<Delivery> selectDelivery(@Param("mname")String mname ,@Param("address") String address);
}
