//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ylht.util;

import com.ylht.enums.ApiResponseEnum;

public class ApiResponse {
    private int errCode = 0;
    private String errMsg;
    private Object data;

    public ApiResponse() {
    }

    public ApiResponse(Object data) {
        this.data = data;
    }

    public ApiResponse(ApiResponseEnum apiResponseEnum) {
        this.errCode = apiResponseEnum.getErrCode();
        this.errMsg = apiResponseEnum.getErrMsg();
    }

    public int getErrCode() {
        return this.errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        return "ApiResponse{errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + ", data=" + this.data + '}';
    }
}
