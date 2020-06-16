package com.ylht.serviceImpl;

import com.ylht.mapper.NavigationMapper;
import com.ylht.pojo.Navigation;
import com.ylht.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavigationServiceImpl implements NavigationService {
    @Autowired
    private NavigationMapper navigationMapper;
    public List<Navigation> getAll() {
        return navigationMapper.selectAll();
    }

    public List<Navigation> getData(Navigation navigation) {
        return navigationMapper.select(navigation);
    }

    public Navigation getOne(Navigation navigation) {
        return navigationMapper.selectOne(navigation);
    }

    public Integer add(Navigation navigation) {
        return navigationMapper.insert(navigation);
    }

    public Integer del(Navigation navigation) {
        return navigationMapper.delete(navigation);
    }

    public Integer upd(Navigation navigation) {
        return navigationMapper.updateByPrimaryKey(navigation);
    }
}
