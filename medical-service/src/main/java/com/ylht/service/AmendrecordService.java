package com.ylht.service;

import com.ylht.pojo.Amendrecord;

import java.util.List;

public interface AmendrecordService extends DataService<Amendrecord> {
    List<Amendrecord> getRecord(Amendrecord amendrecord);
    Amendrecord getRecordOne(Amendrecord amendrecord);
}
