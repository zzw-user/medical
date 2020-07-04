package com.ylht.controller.cyh;

import com.ylht.pojo.Mpuser;
import com.ylht.pojo.Navigation;
import com.ylht.service.NavService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ylht.util.GetUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NavController {
    @Autowired
    private NavService navService;

    public NavController() {
    }

    @RequestMapping({"/findMenu"})
    public Object findMenu(HttpServletRequest request, HttpServletResponse response) {
        Integer userId = GetUserUtil.getUserId(request, response);
        List<Navigation> list = this.navService.findMenu(userId);
        return list;
    }
}
