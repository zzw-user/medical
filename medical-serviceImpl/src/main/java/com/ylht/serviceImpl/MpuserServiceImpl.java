package com.ylht.serviceImpl;

import com.ylht.mapper.MpuserMapper;
import com.ylht.pojo.Mpuser;
import com.ylht.service.MpuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MpuserServiceImpl implements MpuserService {
    @Autowired
    private MpuserMapper mpuserMapper;
    public List<Mpuser> getAll() {
        return mpuserMapper.selectAll();
    }

    public List<Mpuser> getData(Mpuser mpuser) {
        return mpuserMapper.select(mpuser);
    }

    public Mpuser getOne(Mpuser mpuser) {
        return mpuserMapper.selectOne(mpuser);
    }

    public Integer add(Mpuser mpuser) {
        return mpuserMapper.insert(mpuser);
    }

    public Integer del(Mpuser mpuser) {
        return mpuserMapper.delete(mpuser);
    }

    public Integer upd(Mpuser mpuser) {
        return mpuserMapper.updateByPrimaryKey(mpuser);
    }
}
