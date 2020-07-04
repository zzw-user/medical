package com.ylht.service;

import com.ylht.pojo.Arpart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArpartService extends DataService<Arpart> {
    List<Arpart> selectBj(String coding, String aname,Integer tid);

}
