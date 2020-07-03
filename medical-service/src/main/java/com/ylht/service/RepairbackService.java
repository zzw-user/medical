package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Payareturnvisit;

public interface RepairbackService {
    PageInfo<Payareturnvisit> selePayareturnvisit(String pname, String way, Integer aftertype, Integer index, Integer pagesize);
}
