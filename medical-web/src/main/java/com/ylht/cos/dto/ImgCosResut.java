package com.ylht.cos.dto;

/**
 * cos对象上传的图片实体类
 * 
 * @author pete_zuo
 *
 */
public class ImgCosResut {
	// 返回上传的路径
	private String location;
	// 返回存储的对象桶
	private String bucket;
	// 返回的key
	private String key;

	// ETag
	private String eTag;
	// 执行的状态码
	private int statusCode;

	@Override
	public String toString() {
		return "ImgCosResut [location=" + location + ", bucket=" + bucket
				+ ", key=" + key + ", eTag=" + eTag + ", statusCode="
				+ statusCode + "]";
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String geteTag() {
		return eTag;
	}

	public void seteTag(String eTag) {
		this.eTag = eTag;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
