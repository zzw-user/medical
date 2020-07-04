package com.ylht.mapper.xzh;

import com.ylht.pojo.Payareturnvisit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RepairbackMapper {
    List<Payareturnvisit> selePayareturnvisit(@Param("pname") String pname, @Param("way") String way, @Param("aftertype")Integer aftertype);

}
