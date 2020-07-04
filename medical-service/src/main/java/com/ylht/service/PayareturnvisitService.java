package com.ylht.service;

import com.ylht.pojo.Payareturnvisit;

import java.util.List;

public interface PayareturnvisitService extends DataService<Payareturnvisit>{
    List<Payareturnvisit> getPayare(Payareturnvisit payareturnvisit);
    Payareturnvisit getPayareOne(Payareturnvisit payareturnvisit);
}
