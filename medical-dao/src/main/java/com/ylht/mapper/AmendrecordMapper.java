package com.ylht.mapper;

import com.ylht.pojo.Amendrecord;
import com.ylht.pojo.Maintainrecord;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AmendrecordMapper extends Mapper<Amendrecord> {
    List<Amendrecord> getRecord(Amendrecord amendrecord);
    Amendrecord getRecordOne(Amendrecord amendrecord);
}
