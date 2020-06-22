package com.ylht.mapper;

import com.ylht.pojo.Type;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("TypesMapper")
public interface TypesMapper {
    List<Type> getTypeAll(@Param("tname") String tname);
}
