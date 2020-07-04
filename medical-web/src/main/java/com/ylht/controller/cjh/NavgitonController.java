package com.ylht.controller.cjh;

import com.ylht.pojo.Navigation;
import com.ylht.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("Navigation")
public class NavgitonController {

    @Autowired
    private NavigationService navigationService;


    @RequestMapping(value = "/treeload")
    public Object treeload() {
        List<Navigation> navigation = navigationService.getAll();  //查找所有菜单
        List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();    //定义一个map处理json键名问题
        return fun(navigation, result);
    }

    private Object fun(List<Navigation> navigation, List<HashMap<String, Object>> result) {

        for (Navigation d : navigation) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            if (d.getFatherid() == null) {
                map.put("id", d.getNid());
//                map.put("title", d.getNname());
                map.put("spread", true);
                //设置是否展开
                //下级菜单
                //这里可以根据自己需求判断节点默认选中
        /*if(m.getParent() != null || m.getChildren().size() == 0){
            map.put("checked", true);    //设置为选中状态
        }*/
            }
            if (d.getFatherid() == d.getNid()) {
                HashMap<String, Object> map1 = new HashMap<String, Object>();
//                map1.put("name", d.getNname());
                map.put("children", map1);
            }
            result.add(map);
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
