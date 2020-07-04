package com.ylht.service;

import com.ylht.pojo.Maintainrecord;

import java.util.List;

public interface MaintainrecordService extends DataService<Maintainrecord>{
    List<Maintainrecord> getRecord(Maintainrecord maintainrecord);
    Maintainrecord getRecordOne(Maintainrecord maintainrecord);
}
