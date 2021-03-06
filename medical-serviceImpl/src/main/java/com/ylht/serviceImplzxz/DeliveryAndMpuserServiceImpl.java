package com.ylht.serviceImplzxz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapperzxz.DeliveryAndMpuserMapper;
import com.ylht.pojo.DeliveryAndMpuser;
import com.ylht.pojo.Product;
import com.ylht.servicezxz.DeliveryAndMpuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAndMpuserServiceImpl implements DeliveryAndMpuserService {
    @Autowired
    private DeliveryAndMpuserMapper deliveryAndMpuserMapper;


    public PageInfo<DeliveryAndMpuser> pageInfoDeliveryAndMpuser(Integer aftertype, String realname, String address, String coding, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<DeliveryAndMpuser> list = deliveryAndMpuserMapper.getDeliveryAndMpus(aftertype,realname, address, coding);
        PageInfo<DeliveryAndMpuser> page = new PageInfo<DeliveryAndMpuser>(list);
        return page;
    }

    public Product getproductByCoding(String coding) {
        return deliveryAndMpuserMapper.getproductByCod(coding);
    }

}
