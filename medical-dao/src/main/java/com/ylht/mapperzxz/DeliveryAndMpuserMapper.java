package com.ylht.mapperzxz;

import com.ylht.pojo.DeliveryAndMpuser;
import com.ylht.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeliveryAndMpuserMapper {
    List<DeliveryAndMpuser> getDeliveryAndMpuser(@Param("realname") String realname,@Param("address") String address,
                                                 @Param("coding")String coding,
                                                 @Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);
    Product getproductByCoding(@Param("coding") String coding);
}
