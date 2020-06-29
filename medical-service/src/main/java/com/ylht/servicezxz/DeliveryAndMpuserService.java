package com.ylht.servicezxz;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.DeliveryAndMpuser;
import com.ylht.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliveryAndMpuserService {
    List<DeliveryAndMpuser> getDeliveryAndMpuser(@Param("realname") String realname,@Param("address") String address,
                                                 @Param("coding")String coding,
                                                 @Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);
    PageInfo<DeliveryAndMpuser> pageInfoDeliveryAndMpuser(String realname, String address, String coding, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
    int getproductByCoding(String coding);
}
