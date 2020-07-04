package com.ylht.servicezxz;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.FullMaintainrecord;
import com.ylht.pojo.InstallationRecordEvaluation;
import com.ylht.pojo.Maintainrecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FullService {
    PageInfo<FullMaintainrecord> pageFullMaintainrecord(@Param("address") String address, @Param("status") Integer status,
                                                                            @Param("coding") String coding, @Param("realname") String realname,
                                                                            @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
    int updateMaintainrecordByRid(Maintainrecord maintainrecord);
}
