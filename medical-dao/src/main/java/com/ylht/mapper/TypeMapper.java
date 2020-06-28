package com.ylht.mapper;

import com.ylht.pojo.Type;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TypeMapper extends Mapper<Type> {
    List<Type> getTypeAll(@Param("tname") String tname);

}
