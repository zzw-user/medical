package com.ylht.cos.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;

import com.ylht.cos.dao.TencentCosDao;
import com.ylht.cos.dto.CosPage;
import com.ylht.cos.dto.ImageObjectRuten;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.AnonymousCOSCredentials;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.COSObjectSummary;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.model.UploadResult;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.transfer.TransferManager;
import com.qcloud.cos.transfer.Upload;

/**
 * cos对象存储业务逻辑层
 * 
 * @author pete_zuo
 *
 */
@Service
public class ITencentCosDaoImpl implements TencentCosDao {


	private Long APP_ID = 1302574033L;

	private String SECRET_ID = "AKIDDLDzc5dKhwb5HJwix2z5CD1gHi9V64IM";

	private String SECRET_KEY = "86v31qohQzJTHxaFE2iU6A4d1OBxIyVs";

	private String BUCKET ="zzwzz-1302574033";


	private String REGION = "ap-nanjing";

	@Override
	public URL ceneratePresignedDownloadUrlAnonymous(String key) {
		// 1 初始化用户身份信息, 匿名身份不用传入ak sk
		COSCredentials cred = new AnonymousCOSCredentials();
		// 2 设置bucket的区域, COS地域的简称请参照
		// https://www.qcloud.com/document/product/436/6224
		ClientConfig clientConfig = new ClientConfig(new Region(REGION));
		// 3 生成cos客户端
		COSClient cosclient = new COSClient(cred, clientConfig);
		// String bucketName = BUCKET+;
		ObjectMetadata objectMetadata = cosclient
				.getObjectMetadata(BUCKET, key);
		System.out.println(objectMetadata.toString());
		GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(
				BUCKET, key, HttpMethodName.GET);
		URL url = cosclient.generatePresignedUrl(req);
		cosclient.shutdown();
		return url;
	}

	@Override
	public URL ceneratePresignedUploadUrlSign(String bucket,
			Date expirationTime, String key) {
		COSClient cosclient = getClientConfig();

		if (bucket == null) {
			bucket = BUCKET;
		}
		// 设置临时uil过期时间
		if (expirationTime == null) {
			expirationTime = new Date(
					System.currentTimeMillis() + 10 * 60 * 1000);
		}
		URL url = cosclient.generatePresignedUrl(bucket, key, expirationTime);
		// System.out.println(url.toString());
		//
		// //用临时的url 去存入数据 这里有一个问题 key定死了 只能往固定的key里面存

		cosclient.shutdown();
		return url;
	}

	@Override
	public String ceneratePresignedUploadUrl(Date expirationTime, String key,
			File file) {
		COSCredentials cred = new AnonymousCOSCredentials();
		// 2 设置bucket的区域, COS地域的简称请参照
		// https://www.qcloud.com/document/product/436/6224
		ClientConfig clientConfig = new ClientConfig(new Region(REGION));
		// 3 生成cos客户端
		COSClient cosclient = new COSClient(cred, clientConfig);
		// 设置临时uil过期时间
		if (expirationTime == null) {
			expirationTime = new Date(
					System.currentTimeMillis() + 10 * 60 * 1000);
		}
		URL url = cosclient.generatePresignedUrl(BUCKET, key, expirationTime);
		OutputStreamWriter out = null;
		InputStream in = null;
		try {
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("PUT");
			in = new FileInputStream(file);
			out = new OutputStreamWriter(connection.getOutputStream());
			int len = in.read();
			while (len != -1) {
				out.write(len);
				len = in.read();
			}
			in.close();
			out.flush();
			out.close();

			// 存入 返回响应的状态码 200是成功
			int responseCode = connection.getResponseCode();
			if (responseCode == 200) {
				return url.toString();
			}
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				out = null;
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				in = null;
			}
			cosclient.shutdown();
		}

		return null;
	}

	@Override
	public ImageObjectRuten putobjectStandard(String key, File file,
											  StorageClass storageClass) {
		ImageObjectRuten imageObjectRuten = new ImageObjectRuten();
		imageObjectRuten.setBucket(BUCKET);
		imageObjectRuten.setKey(key);
		COSClient cosclient = getClientConfig();
		if (storageClass == null) {
			storageClass = StorageClass.Standard_IA;
		}
		PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET, key,
				file);

		// 设置存储类型：标准存储（Standard）,
		// 低频存储（Standard_IA）和归档存储（ARCHIVE）。默认是标准存储（Standard）
		putObjectRequest.setStorageClass(storageClass);
		String etag = null;
		try {
			PutObjectResult putObjectResult = cosclient
					.putObject(putObjectRequest);
			// putobjectResult 会返回文件的 etag 2e5d50e607547ca1e1b0fd778fb39e41

			etag = putObjectResult.getETag();
			if (etag != null) {
				imageObjectRuten.setEtag(etag);
				System.out.println(etag);
				imageObjectRuten.setStatusCode(200);
				imageObjectRuten
						.setLocation(key);
				//ceneratePresignedDownloadUrlAnonymous(key)
				//								.toString()

			}
		} catch (CosServiceException e) {
			e.printStackTrace();
		} catch (CosClientException e) {
			e.printStackTrace();
		}
		// 关闭客户端
		cosclient.shutdown();

		return imageObjectRuten;
	}

	private static COSClient cosclient = null;

	/**
	 * 私有化 用户的key和id调用 获得 cos客户端的方法
	 * 
	 * @param
	 *
	 * @return COSClient 客户端
	 */
	private COSClient getClientConfig() {
		if (cosclient == null) {
			synchronized (this) {
				if (cosclient == null) {
					// 1 初始化用户身份信息(secretId, secretKey)
					COSCredentials cred = new BasicCOSCredentials(SECRET_ID,
							SECRET_KEY);
					ClientConfig clientConfig = new ClientConfig(new Region(
							REGION));
					// 3 生成cos客户端
					cosclient = new COSClient(cred, clientConfig);
				}

			}
		}
		return cosclient;
	}

	@Override
	public boolean DelSingleFile(String key) {
		// 3 生成cos客户端
		COSClient cosclient = getClientConfig();
		try {
			cosclient.deleteObject(BUCKET, key);
		} catch (CosServiceException e) { // 如果是其他错误, 比如参数错误，
											// 身份验证不过等会抛出CosServiceException
			e.printStackTrace();
			return false;
		} catch (CosClientException e) { // 如果是客户端错误，比如连接不上COS
			e.printStackTrace();
			return false;
		} finally {
			// 关闭客户端
			cosclient.shutdown();
		}
		return true;
	}



	public String uploadCosObject(String key, File file) {

		COSClient cosclient = getClientConfig();
		TransferManager transferManager = new TransferManager(cosclient);
		PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET, key,
				file);
		Upload upload = transferManager.upload(putObjectRequest);
		// 等待传输结束（如果想同步的等待上传结束，则调用 waitForCompletion）
		UploadResult uploadResult = null;
		try {
			uploadResult = upload.waitForUploadResult();
			if (uploadResult.getKey() != null) {
				return key;
					//	ceneratePresignedDownloadUrlAnonymous(uploadResult.getKey()).toString();
			}

		} catch (CosServiceException e1) {
			e1.printStackTrace();
		} catch (CosClientException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		return null;
	}

}
