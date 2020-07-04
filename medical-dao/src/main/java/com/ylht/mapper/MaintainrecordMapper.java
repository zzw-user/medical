package com.ylht.mapper;

import com.ylht.pojo.Maintainrecord;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MaintainrecordMapper extends Mapper<Maintainrecord> {
    List<Maintainrecord> getRecord(Maintainrecord maintainrecord);
    Maintainrecord getRecordOne(Maintainrecord maintainrecord);
}
