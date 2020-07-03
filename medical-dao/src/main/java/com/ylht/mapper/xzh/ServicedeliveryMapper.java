package com.ylht.mapper.xzh;

import com.ylht.pojo.Delivery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ServicedeliveryMapper {
    List<Delivery> seleDelivery(@Param("mname") String mname, @Param("address") String address);
}
