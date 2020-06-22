package com.ylht.mapper;

import com.ylht.pojo.Mpuser;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("usermapper")
public interface UserMapper {
    List<Mpuser> getUserAll(@Param("mname")String mname,@Param("roleid")Integer roleid);
}
