package com.ylht.controller.cjh;

import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Mpuser;
import com.ylht.service.MpuserService;
import com.ylht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("UserManagement")
public class UserManagementController {
    @Autowired
    private MpuserService mpuserService;


    @RequestMapping("getUser")
    public ResultMap<List<Mpuser>> getRole(Mpuser mpuser){
        List<Mpuser> list=mpuserService.getData(mpuser);
        return  new ResultMap<List<Mpuser>>("",list,0,list.size());
    }

    @RequestMapping("getUserALL")
    public ResultMap<List<Mpuser>> getRoles(String mname,Integer roleid,String realname,Integer page,Integer limit){
        PageInfo<Mpuser> pages=mpuserService.getUserAll(mname,roleid,realname,page,limit);
        return  new ResultMap<List<Mpuser>>("",pages.getList(),0,pages.getTotal());
    }

    @RequestMapping("addUser")
    public boolean addRole(Mpuser mpuser){
        int result=mpuserService.add(mpuser);
        if (result>0){
            return true;
        }
        return  false;
    }
    @RequestMapping("updateUser")
    public boolean updRole(Mpuser mpuser){
        int result=mpuserService.upd(mpuser);
        if (result>0){
            return true;
        }
        return  false;
    }

    @RequestMapping("delUser")
    public boolean delRole(Mpuser mpuser){
        int result=mpuserService.del(mpuser);
        if (result>0){
            return true;
        }
        return  false;
    }

    @RequestMapping("getUserOne")
    public Mpuser get(Mpuser mpuser){
        Mpuser mpusers=mpuserService.getOne(mpuser);
        return  mpusers;
    }

}
