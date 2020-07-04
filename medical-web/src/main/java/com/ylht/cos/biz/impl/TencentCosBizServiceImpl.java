package com.ylht.cos.biz.impl;

import java.io.File;
import java.net.URL;
import java.util.Date;

import com.ylht.cos.biz.ITencentCosBizService;
import com.ylht.cos.dao.TencentCosDao;
import com.ylht.cos.dto.ImageObjectRuten;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TencentCosBizServiceImpl implements ITencentCosBizService {
	@Autowired
	private TencentCosDao cosDao;

	@Override
	public ImageObjectRuten setObjectUpload(String key, File file) {
		return cosDao.putobjectStandard(key, file, null);
	}

	@Override
	public URL ceneratePresignedUploadUrlSign(String bucket,
			Date expirationTime, String key) {
		return cosDao.ceneratePresignedUploadUrlSign(bucket, expirationTime,
				key);
	}
}
