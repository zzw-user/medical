package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Mpuser;

public interface UserService {
    PageInfo<Mpuser> getUserAll(String mname,Integer roleid,Integer pageNo, Integer pageSize);
}
