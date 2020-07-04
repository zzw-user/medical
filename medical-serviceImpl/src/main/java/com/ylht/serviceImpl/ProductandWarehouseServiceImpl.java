package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.ProductandWarehouseMapper;
import com.ylht.pojo.*;
import com.ylht.service.ProductandWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductandWarehouseServiceImpl implements ProductandWarehouseService {
    @Autowired
    private ProductandWarehouseMapper productandWarehouseMapper;

    public List<Product> selectproduct(String pname, String coding, Integer wid, Integer typeid) {
        return productandWarehouseMapper.selectproduct(pname,coding,wid,typeid);
    }

    public PageInfo<Product> pageinfo(Integer pageNum, Integer pageSize, String pname, String coding, Integer wid, Integer typeid) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> list=productandWarehouseMapper.selectproduct(pname,coding,wid,typeid);
        PageInfo<Product> page=new PageInfo<Product>(list);
        return page;
    }
    public PageInfo<Orderforms> pagelist(Integer pageNum, Integer pageSize, String serialnumber, Integer operator, String coding) {
        PageHelper.startPage(pageNum,pageSize);
        List<Orderforms> list=productandWarehouseMapper.selectOrderform(serialnumber,operator,coding);
        PageInfo<Orderforms> page = new PageInfo<Orderforms>(list);
        return page;
    }

    public PageInfo<Product> pageinfoproductAndInventory(Integer pageNum, Integer pageSize, String pname) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> list=productandWarehouseMapper.productAndInventory(pname);
        PageInfo<Product> page=new PageInfo<Product>(list);
        return page;
    }

    public PageInfo<Arparts> arpartAndInventory(Integer pageNum, Integer pageSize, String aname) {
        PageHelper.startPage(pageNum,pageSize);
        List<Arparts> list=productandWarehouseMapper.arpartAndInventory(aname);
        PageInfo<Arparts> page=new PageInfo<Arparts>(list);
        return page;
    }


    public List<Product> productAndInventory(Integer pageNum, Integer pageSize,String pname) {
        PageHelper.startPage(pageNum,pageSize);
        return productandWarehouseMapper.productAndInventory(pname);
    }

    public int updProduct(Product product) {
        return productandWarehouseMapper.updProduct(product);
    }

    public int addProduct(Product product) {
        return productandWarehouseMapper.addProduct(product);
    }

    public Product selectProductOne(Integer pid) {
        return productandWarehouseMapper.selectProductOne(pid);
    }

    public List<Orderforms> selectOrderform(String serialnumber, Integer operator, String coding) {

        return productandWarehouseMapper.selectOrderform(serialnumber,operator,coding);
    }




}
