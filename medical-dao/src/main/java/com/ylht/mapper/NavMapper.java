package com.ylht.mapper;

import com.ylht.pojo.Navigation;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NavMapper {
    String getJurisdictionByUserid(@Param("userid") Integer var1);

    Navigation getFatherByNid(@Param("nid") Integer var1);

    List<Navigation> getChildByFatherid(@Param("sz") String[] var1, @Param("fatherid") Integer var2);
}
