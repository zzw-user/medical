package com.ylht.mapper;

import com.ylht.pojo.Information;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface InformationMapper extends Mapper<Information> {
    @Select({"select * FROM information WHERE recipient = #{recipient} and sender!=#{sender}"})
    List<Information> selectNotXitong(Information var1);

    @Update({"update information set isread=#{isread} where recipient=#{recipient}"})
    int updateIsread(Information var1);
}
