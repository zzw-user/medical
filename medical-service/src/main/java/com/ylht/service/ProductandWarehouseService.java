package com.ylht.service;

import com.ylht.pojo.Product;

import java.util.List;

public interface ProductandWarehouseService {
    List<Product> selectproduct(String pname, String coding);
}
