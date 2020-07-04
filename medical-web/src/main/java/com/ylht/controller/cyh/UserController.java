package com.ylht.controller.cyh;

import com.ylht.pojo.Mpuser;
import com.ylht.service.MpuserService;
import com.ylht.util.GetUserUtil;
import com.ylht.util.JwtUtil;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private MpuserService mpuserService;

    public UserController() {
    }

    @RequestMapping({"/getUser"})
    public Object d(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        String userId = JwtUtil.getUserId(token);
        String username = JwtUtil.getUsername(token);
        System.out.println(userId);
        System.out.println(username);
        Mpuser mpuser = new Mpuser();
        mpuser.setMname(username).setMpid(Integer.parseInt(userId));

        return mpuser;
    }

    @RequestMapping({"/getUserById"})
    public String getUserById(HttpServletRequest request, HttpServletResponse response, String oldPassword) {
        Integer userId = GetUserUtil.getUserId(request, response);
        Mpuser mpuser = (Mpuser)this.mpuserService.getOne((new Mpuser()).setMpid(userId));
        if (mpuser != null) {
            return mpuser.getPassword().equals(oldPassword) ? "true" : "false";
        } else {
            return "false";
        }
    }

    @RequestMapping({"/updatePassword"})
    public String updatePassword(HttpServletRequest request, HttpServletResponse response, Mpuser mpuser) {
        Integer userId = GetUserUtil.getUserId(request, response);
        mpuser.setMpid(userId);
        int i = this.mpuserService.upd(mpuser);
        return i > 0 ? "true" : "false";
    }

    @RequestMapping({"/loginVerify"})
    public Object loginVerify(Mpuser mpuser) {
        HashMap<String, Object> hm = new HashMap();
        Mpuser mpuser1 = (Mpuser)this.mpuserService.getOne(mpuser);
        if (mpuser1 != null) {
            String token = JwtUtil.sign(mpuser1.getMname(), mpuser1.getMpid().toString());
            if (token != null) {
                hm.put("token", token);
                hm.put("code", "0");
            }
        } else {
            hm.put("code", "1");
            hm.put("message", "登录失败");
        }

        return hm;
    }

    @RequestMapping({"/addUser"})
    public String addUser(Mpuser mpuser) {
        int i = this.mpuserService.add(mpuser);
        return i > 0 ? "true" : "false";
    }
}
