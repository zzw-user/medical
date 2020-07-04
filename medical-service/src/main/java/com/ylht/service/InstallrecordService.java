package com.ylht.service;

import com.ylht.pojo.Installrecord;

import java.util.List;

public interface InstallrecordService extends DataService<Installrecord>{
    List<Installrecord> getRecord(Installrecord installrecord);
    Installrecord getRecordOne(Installrecord installrecord);
}
