package com.ylht.cos.dao;

import java.io.File;
import java.net.URL;
import java.util.Date;

import com.qcloud.cos.model.StorageClass;
import com.ylht.cos.dto.ImageObjectRuten;

public interface TencentCosDao {

	/**
	 * 根据对象桶名字 和key值 获得 对应对象下载路径 不用传入用户数据信息 但是不会包含私密签名 只是一个下载链接
	 * 
	 * 对象对应的key
	 * 
	 * @param region
	 *            对象桶地址 允许null
	 * @return 下载路径
	 */
	public URL ceneratePresignedDownloadUrlAnonymous(String key);

	/**
	 * 生成预上传的路径的方法 会生成 sign
	 * 
	 * @param bucket
	 *            对象桶名字 可以为null
	 * @param expirationTime
	 *            url过期时间 System.currentTimeMillis()当前时间往后走
	 * @param key
	 *            存对象的key 必须有
	 * @return 上传url?sign 可以通过io流写入
	 */
	public URL ceneratePresignedUploadUrlSign(String bucket,
                                              Date expirationTime, String key);

	/**
	 * 生成预上传文件的路径的方法 不会有用户信息暴露 只会生成路径 不会带Sign
	 *
	 * @param expirationTime
	 *            url过期时间 System.currentTimeMillis()当前时间往后走
	 * @param key
	 *            存对象的key 必须有
	 * @return 上传url 可以通过io流写入
	 */
	public String ceneratePresignedUploadUrl(Date expirationTime, String key,
                                             File file);

	/**
	 * 公开的上传的方法 不生成路径
	 *
	 * @param key
	 *            存储对象的key notnull
	 * @param file
	 *            存入的文件 notnull
	 * @param storageClass
	 *            存储的速度 低档 Standard_IA 中档 Standard (default) 归档存储 ARCHIVE
	 *            可以为null
	 * @return 该对象的唯一字符串 用该字符串去对比对象 可以判断是否为同一个对象
	 */
	public ImageObjectRuten putobjectStandard(String key, File file,
											  StorageClass storageClass);

	/**
	 * 根据key值删除对应数据对象
	 * 
	 * @param key
	 *            对象存储的key
	 * @return 是否删除
	 */
	public boolean DelSingleFile(String key);



	public String uploadCosObject(String key, File file);
}
