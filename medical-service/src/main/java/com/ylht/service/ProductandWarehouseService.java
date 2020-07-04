package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Arpart;
import com.ylht.pojo.Arparts;
import com.ylht.pojo.Orderforms;
import com.ylht.pojo.Product;

import java.util.List;

public interface ProductandWarehouseService {
    List<Product> selectproduct(String pname,String coding,Integer wid,Integer typeid );
    PageInfo<Product> pageinfo(Integer pageNum,Integer pageSize,String pname,String coding,Integer wid,Integer typeid);
    int updProduct(Product product);
    int addProduct(Product product);
    Product selectProductOne(Integer pid);
    PageInfo<Orderforms> pagelist(Integer pageNum,Integer pageSize,String serialnumber, Integer operator, String coding);
    PageInfo<Product> pageinfoproductAndInventory(Integer pageNum, Integer pageSize,String pname);
    PageInfo<Arparts> arpartAndInventory(Integer pageNum, Integer pageSize, String aname);
}
