package com.ylht.mapper.xzh;

import com.ylht.pojo.Payareturnvisits;
import com.ylht.pojo.Warehouses;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RepairbackMapper {
    List<Payareturnvisits> selePayareturnvisit(@Param("pname") String pname, @Param("way") String way);

}
