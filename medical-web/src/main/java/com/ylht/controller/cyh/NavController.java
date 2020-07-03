package com.ylht.controller.cyh;

import com.ylht.pojo.Mpuser;
import com.ylht.pojo.Navigation;
import com.ylht.service.NavService;
import java.util.List;
import javax.servlet.http.HttpSession;
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
    public Object findMenu(HttpSession session) {
        Mpuser user = (Mpuser)session.getAttribute("user");
        List<Navigation> list = this.navService.findMenu(1);
        return list;
    }
}
