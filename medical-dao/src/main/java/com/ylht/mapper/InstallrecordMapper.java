package com.ylht.mapper;

import com.ylht.pojo.Installrecord;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface InstallrecordMapper extends Mapper<Installrecord> {
    List<Installrecord> getRecord(Installrecord installrecord);
    Installrecord getRecordOne(Installrecord installrecord);
}
