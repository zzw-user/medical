package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Mpuser;

public interface MpuserService extends DataService<Mpuser>{
    PageInfo<Mpuser> getUserAll(String mname, Integer roleid,String realname, Integer pageNo, Integer pageSize);

}
