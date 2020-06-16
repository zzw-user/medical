package com.ylht.serviceImpl;

import com.ylht.mapper.DistrictMapper;
import com.ylht.pojo.District;
import com.ylht.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    public List<District> getAll() {
        return districtMapper.selectAll();
    }

    public List<District> getData(District district) {
        return districtMapper.select(district);
    }

    public District getOne(District district) {
        return districtMapper.selectOne(district);
    }

    public Integer add(District district) {
        return districtMapper.insert(district);
    }

    public Integer del(District district) {
        return districtMapper.delete(district);
    }

    public Integer upd(District district) {
        return districtMapper.updateByPrimaryKey(district);
    }
}
