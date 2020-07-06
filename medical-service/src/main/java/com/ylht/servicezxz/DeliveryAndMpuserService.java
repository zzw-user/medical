package com.ylht.servicezxz;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.DeliveryAndMpuser;
import com.ylht.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliveryAndMpuserService {
       PageInfo<DeliveryAndMpuser> pageInfoDeliveryAndMpuser(Integer aftertype,String realname, String address, String coding, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
    Product getproductByCoding(String coding);
}
