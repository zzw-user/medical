package com.ylht.mapper;

import com.ylht.pojo.Payareturnvisit;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PayareturnvisitMapper extends Mapper<Payareturnvisit> {
    List<Payareturnvisit> getPayare(Payareturnvisit payareturnvisit);
    Payareturnvisit getPayareOne(Payareturnvisit payareturnvisit);
}
