package com.ylht.liujiancontroller;

import com.ylht.service.ProductandWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductandWarehouseController {
    @Autowired
    private ProductandWarehouseService productandWarehouseService;
    @RequestMapping("selectProduct")
    public Object selectProduct(){
        return null;
    }
}
