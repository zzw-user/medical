package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Payareturnvisits;
import com.ylht.pojo.Warehouses;

public interface RepairbackService {
    PageInfo<Payareturnvisits> selePayareturnvisit(String pname, String way, Integer index, Integer pagesize);
}
