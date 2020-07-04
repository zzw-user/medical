package com.ylht.mapper;

import com.ylht.pojo.Navigation;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NavigationMapper extends Mapper<Navigation> {
    @Select("SELECT * FROM navigation WHERE nid NOT IN (SELECT fatherid FROM Navigation WHERE fatherid  IN (SELECT nid FROM navigation))")
    List<Navigation> getNavsss();
}
