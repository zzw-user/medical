package com.ylht.serviceImpl;

import com.ylht.mapper.ProductMapper;
import com.ylht.pojo.Product;
import com.ylht.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    public List<Product> getAll() {
        return productMapper.selectAll();
    }

    public List<Product> getData(Product product) {
        return productMapper.select(product);
    }

    public Product getOne(Product product) {
        return productMapper.selectOne(product);
    }

    public Integer add(Product product) {
        return productMapper.insert(product);
    }

    public Integer del(Product product) {
        return productMapper.delete(product);
    }

    public Integer upd(Product product) {
        return productMapper.updateByPrimaryKey(product);
    }
}
