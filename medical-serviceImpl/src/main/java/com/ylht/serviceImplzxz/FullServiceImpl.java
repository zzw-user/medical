package com.ylht.serviceImplzxz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapperzxz.FullMapper;
import com.ylht.pojo.FullMaintainrecord;
import com.ylht.pojo.InstallationRecordEvaluation;
import com.ylht.pojo.Maintainrecord;
import com.ylht.servicezxz.FullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FullServiceImpl implements FullService {
    @Autowired
    private FullMapper fullMapper;

    public PageInfo<FullMaintainrecord> pageFullMaintainrecord(String address, Integer status, String coding, String realname, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<FullMaintainrecord> list = fullMapper.getFull(address, status, coding, realname);
        PageInfo<FullMaintainrecord> pageInfo = new PageInfo<FullMaintainrecord>(list);
        return pageInfo;
    }

    public int updateMaintainrecordByRid(Maintainrecord maintainrecord) {
        return fullMapper.updateMaintainrecordByRid(maintainrecord);
    }
}
