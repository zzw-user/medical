package com.ylht.cos.biz;


import com.ylht.cos.dto.ImageObjectRuten;

import java.io.File;
import java.net.URL;
import java.util.Date;

public interface ITencentCosBizService {

	public ImageObjectRuten setObjectUpload(String key, File file);

	public URL ceneratePresignedUploadUrlSign(String bucket,
                                              Date expirationTime, String key);

}
