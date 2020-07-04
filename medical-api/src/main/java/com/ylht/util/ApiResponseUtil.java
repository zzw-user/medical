//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ylht.util;

import com.ylht.enums.ApiResponseEnum;

public class ApiResponseUtil {
    public ApiResponseUtil() {
    }

    public static ApiResponse getApiResponse(Object data) {
        return getApiResponse(data, ApiResponseEnum.SUCCESS.getErrCode(), ApiResponseEnum.SUCCESS.getErrMsg());
    }

    public static ApiResponse getApiResponse(int code, String msg) {
        return getApiResponse((Object)null, code, msg);
    }

    public static ApiResponse getApiResponse(ApiResponseEnum apiResponseEnum) {
        return getApiResponse(apiResponseEnum.getErrCode(), apiResponseEnum.getErrMsg());
    }

    public static ApiResponse getApiResponse(Object data, int code, String msg) {
        ApiResponse apiResponse = new ApiResponse(data);
        apiResponse.setErrCode(code);
        apiResponse.setErrMsg(msg);
        return apiResponse;
    }
}
