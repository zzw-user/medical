package com.ylht.controller.zzw;

import com.ylht.pojo.Mpuser;
import com.ylht.service.MpuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("zMpuser")
public class ZzwMpuserController {
    @Autowired
    private MpuserService mpuserService;

    @RequestMapping("login")
    public boolean login(Mpuser mpuser){
        Mpuser mpuser1 = mpuserService.getOne(mpuser);
        if (mpuser1!=null){
            if (mpuser1.getPassword().equals(mpuser.getPassword())){
                return true;
            }
        }
        return false;
    }
}
