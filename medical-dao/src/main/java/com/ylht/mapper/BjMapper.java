package com.ylht.mapper;

import com.ylht.pojo.Arpart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BjMapper {
    List<Arpart> selectBj(@Param("coding")String coding,@Param("aname")String aname,@Param("tid")Integer tid);
}
