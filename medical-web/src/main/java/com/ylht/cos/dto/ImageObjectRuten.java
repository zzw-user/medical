package com.ylht.cos.dto;

/**
 * 对象存储上传返回实体类
 * 
 * @author pete_zuo
 *
 */
public class ImageObjectRuten {
	private String location;

	private String key;

	private String etag;

	private int statusCode;

	private String bucket;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getEtag() {
		return etag;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	@Override
	public String toString() {
		return "ImageObjectRuten [location=" + location + ", key=" + key
				+ ", etag=" + etag + ", statusCode=" + statusCode + ", bucket="
				+ bucket + "]";
	}

}
