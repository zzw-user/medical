package com.ylht.mapper;

import com.ylht.pojo.Product;

import java.util.List;

public interface ProductandWarehouseMapper {
    List<Product> selectproduct(String pname,String coding);
}
