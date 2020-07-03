package com.ylht.service;

import com.ylht.pojo.Information;
import java.util.List;

public interface InformationService extends DataService<Information> {
    List<Information> selectNotXitong(Information var1);

    int updateIsread(Information var1);
}