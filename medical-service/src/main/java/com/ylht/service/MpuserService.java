package com.ylht.service;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Mpuser;

public interface MpuserService extends DataService<Mpuser>{
    PageInfo<Mpuser> getUserAll(String mname, Integer roleid, Integer pageNo, Integer pageSize);

}
