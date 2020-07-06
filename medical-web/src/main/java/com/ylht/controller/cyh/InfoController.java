package com.ylht.controller.cyh;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.pojo.Information;
import com.ylht.pojo.Mpuser;
import com.ylht.service.InformationService;
import com.ylht.service.MpuserService;
import com.ylht.util.GetUserUtil;
import com.ylht.util.ResultMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("infocyh")
public class InfoController {
    @Autowired
    private InformationService informationService;
    @Autowired
    private MpuserService mpuserService;

    public InfoController() {
    }

    @RequestMapping(
            value = {"/beachDeleteInfo"},
            produces = {"application/json;charset=utf-8"}
    )
    public Object beachDeleteInfo(@RequestBody Integer[] idsz) {
        int sum = 0;

        for(int i = 0; i < idsz.length; ++i) {
            sum += this.informationService.del((new Information()).setId(idsz[i]));
        }

        Map<String, Object> map = new HashMap();
        map.put("code", sum);
        return map;
    }

    @RequestMapping(
            value = {"/beachUpdateInfo"},
            produces = {"application/json;charset=utf-8"}
    )
    public Object beachUpdateInfo(@RequestBody Integer[] idsz) {
        int sum = 0;

        for(int i = 0; i < idsz.length; ++i) {
            sum += this.informationService.upd((new Information()).setId(idsz[i]).setIsread(2));
        }

        Map<String, Object> map = new HashMap();
        map.put("code", sum);
        return map;
    }

    @RequestMapping({"/allUpdateInfo"})
    public Object allUpdateInfo(HttpServletRequest request, HttpServletResponse response) {
        String userId = GetUserUtil.getUserId(request, response).toString();
        int sum = this.informationService.updateIsread((new Information()).setRecipient(userId).setIsread(2));
        Map<String, Object> map = new HashMap();
        map.put("code", sum);
        return map;
    }

    @RequestMapping({"/getInfoByUserId"})
    public Object getInfoByUserId(HttpServletRequest request, String sixin, String sender, Integer limit, Integer page, HttpServletResponse response) {
        String userId = GetUserUtil.getUserId(request, response).toString();
        PageHelper.startPage(page, limit);
        Information informationii = new Information();
        informationii.setRecipient(userId);
        List<Information> list = null;
        if (sender != null && sender != "") {
            informationii.setSender(sender);
            if (sixin != null && sixin != "") {
                list = this.informationService.selectNotXitong(informationii);
            } else {
                list = this.informationService.getData(informationii);
            }
        } else {
            list = this.informationService.getData(informationii);
        }

        for(int i = 0; i < list.size(); ++i) {
            String zh = ((Information)list.get(i)).getSender();
            if (!zh.equals("系统")) {
                Mpuser mpuser = (Mpuser)this.mpuserService.getOne((new Mpuser()).setMpid(Integer.parseInt(((Information)list.get(i)).getSender())));
                Information information = (Information)list.get(i);
                information.setSender(mpuser.getMname());
                list.set(i, information);
            }
        }

        PageInfo<Information> pageInfo = new PageInfo(list);
        ResultMap<List<Information>> resultMap = new ResultMap("", pageInfo.getList(), 0, pageInfo.getTotal());
        return resultMap;
    }
}
