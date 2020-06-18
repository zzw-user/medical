package com.ylht.serviceImpl;

import com.ylht.mapper.ProductandWarehouseMapper;
import com.ylht.pojo.Product;
import com.ylht.service.ProductandWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductandWarehouseServiceImpl implements ProductandWarehouseService {
    @Autowired
    private ProductandWarehouseMapper productandWarehouseMapper;

    public List<Product> selectproduct(String pname, String coding) {
        return productandWarehouseMapper.selectproduct(pname,coding);
    }
}
