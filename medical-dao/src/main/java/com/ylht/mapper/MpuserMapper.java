package com.ylht.mapper;

import com.ylht.pojo.Mpuser;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@RequestMapping("mpuser")
public interface MpuserMapper extends Mapper<Mpuser> {
    List<Mpuser> getUserAll(@Param("mname")String mname, @Param("roleid")Integer roleid, @Param("realname")String realname);
}
