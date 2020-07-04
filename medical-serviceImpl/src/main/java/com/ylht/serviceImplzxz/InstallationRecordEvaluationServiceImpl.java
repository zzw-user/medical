package com.ylht.serviceImplzxz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylht.mapperzxz.InstallationRecordEvaluationMapper;
import com.ylht.pojo.InstallationRecordEvaluation;
import com.ylht.pojo.Installrecord;
import com.ylht.servicezxz.InstallationRecordEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstallationRecordEvaluationServiceImpl implements InstallationRecordEvaluationService {
   @Autowired
   private InstallationRecordEvaluationMapper installationRecordEvaluationMapper;



    public PageInfo<InstallationRecordEvaluation> pageInstallationRecordEvaluation(String address, Integer status, String coding, String realname, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<InstallationRecordEvaluation> list = installationRecordEvaluationMapper.getInstallationRecordEvaluation(address, status, coding, realname);
        PageInfo<InstallationRecordEvaluation> pageInfo = new PageInfo<InstallationRecordEvaluation>(list);
        return pageInfo;
    }

    public int updateInstallrecordByRid(Installrecord installrecord) {
        return installationRecordEvaluationMapper.updateInstallrecordByRid(installrecord);
    }
}
