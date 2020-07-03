package com.ylht.serviceImpl;

import com.ylht.mapper.NavMapper;
import com.ylht.pojo.Navigation;
import com.ylht.service.NavService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NavServiceImpl implements NavService {
    @Autowired
    private NavMapper navMapper;

    public NavServiceImpl() {
    }

    public List<Navigation> findMenu(Integer userid) {
        String jurisdiction = this.navMapper.getJurisdictionByUserid(userid);
        String[] sz = jurisdiction.split(",");
        List<Navigation> allList = new ArrayList();

        for(int i = 0; i < sz.length; ++i) {
            Navigation fatherNid = this.navMapper.getFatherByNid(Integer.parseInt(sz[i]));
            if (fatherNid != null) {
                List<Navigation> navigationList = this.navMapper.getChildByFatherid(sz, fatherNid.getNid());

                for(int k = 0; k < navigationList.size(); ++k) {
                    List<Navigation> navigations = this.navMapper.getChildByFatherid(sz, ((Navigation)navigationList.get(k)).getNid());

                    for(int p = 0; p < navigations.size(); ++p) {
                        List<Navigation> navigations1 = this.navMapper.getChildByFatherid(sz, ((Navigation)navigations.get(p)).getNid());
                        Navigation navigation = (Navigation)navigations.get(p);
                        navigation.setChild(navigations1);
                        navigations.set(p, navigation);
                    }

                    Navigation n = (Navigation)navigationList.get(k);
                    n.setChild(navigations);
                    navigationList.set(k, n);
                }

                fatherNid.setChild(navigationList);
                allList.add(fatherNid);
            }
        }

        return allList;
    }
}
