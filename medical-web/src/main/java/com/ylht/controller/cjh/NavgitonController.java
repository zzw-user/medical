package com.ylht.controller.cjh;

import com.ylht.pojo.Information;
import com.ylht.pojo.Mpuser;
import com.ylht.pojo.Navigation;
import com.ylht.pojo.Role;
import com.ylht.service.NavigationService;
import com.ylht.service.RoleService;
import org.apache.poi.ss.formula.functions.Na;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Predicate;
import org.springframework.data.domain.Sort;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.*;

@RestController
@RequestMapping("Navigation")
public class NavgitonController {

    @Autowired
    private NavigationService navigationService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(
            value = {"/updateNav"}
    )
    public Object updateNav(String jurisdiction,Integer rid) {

            int i = roleService.upd((new Role()).setRid(rid).setJurisdiction(jurisdiction));

        return i>0?"true":"false";
    }


    @RequestMapping(value = "/treeload")
    public Object treeload(Integer rid) {
        Role role;
        String[] sz=null;
        if(rid!=null && rid!=0) {
             role = roleService.getOne(new Role().setRid(rid));
            sz = role.getJurisdiction().split(",");

        }
        List<Navigation> navigation = navigationService.getAll();  //查找所有菜单
        List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();    //定义一个map处理json键名问题
        return fun(navigation, result,0,sz);

    }

    private Object fun(List<Navigation> navigation, List<HashMap<String, Object>> result,Integer zj,String [] sz) {
         List<Navigation> list = navigationService.getNavsss();
        for (Navigation d : navigation) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            if (d.getFatherid() == zj) {
                map.put("id", d.getNid());
                map.put("title", d.getTitle());
                map.put("spread", true);
                List<HashMap<String, Object>> result1 = new ArrayList<HashMap<String, Object>>();
                map.put("children", fun(navigation,result1,d.getNid(),sz));
for(Navigation navigation1:list){

                    try {
                        for (int o = 0; o < sz.length; o++) {
                            if (Integer.parseInt(sz[o]) == d.getNid() && d.getNid()==navigation1.getNid()) {
                                map.put("checked", true);
                            }
                        }
                    } catch (Exception e) {

                    }

}
                result.add(map);
                //设置是否展开
                //下级菜单
                //这里可以根据自己需求判断节点默认选中
        /*if(m.getParent() != null || m.getChildren().size() == 0){
            map.put("checked", true);    //设置为选中状态
        }*/
            }

        }
        return result;
    }

    @RequestMapping(value = "/show")
    public void show(Navigation form, ModelMap map) throws InstantiationException, IllegalAccessException {
        Navigation model = new Navigation();
        Integer id = form.getNid();
        Integer parentId = 0;
        if (id != null) {
            model = navigationService.getOne(form);
            parentId = model.getParent() == null ? 0 : model.getParent().getNid();
        }
        map.put("parentId", parentId);
        map.put("model", model);
    }
}
