package com.ylht.controllerzxz;

import com.ylht.pojo.Mpuser;
import com.ylht.pojo.Role;
import com.ylht.service.MpuserService;
import com.ylht.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("info")
public class infoController {
    @Autowired
    private MpuserService mpuserService;
    @Autowired
    private RoleService roleService;
    @RequestMapping("getMpuser")
    public Mpuser getMpuser(Mpuser mpuser){
        mpuser.setMpid(6);
        return mpuserService.getOne(mpuser);
    }
    @RequestMapping("updateMpuser")
    public String updateMpuser(Mpuser mpuser){
        int i = mpuserService.upd(mpuser);
        return i>0?"ok":"no";
    }
    @RequestMapping("/getRole")
    public List<Role> getRole(){
        return roleService.getAll();
    }
}
