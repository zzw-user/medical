package com.ylht.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapper.UserMapper;
import com.ylht.pojo.Mpuser;
import com.ylht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl  implements UserService {
    @Autowired
    private UserMapper userMapper;
    public PageInfo<Mpuser> getUserAll(String mname, Integer roleid, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Mpuser> list =userMapper.getUserAll(mname,roleid);
        PageInfo<Mpuser> pageInfo=new PageInfo<Mpuser>(list);
        return pageInfo;
    }
}
