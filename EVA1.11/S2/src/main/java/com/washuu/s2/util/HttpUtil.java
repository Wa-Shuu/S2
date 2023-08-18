package com.washuu.s2.util;

import com.washuu.s2.util.Enum.HttpCodeEnum;

import java.util.HashMap;
import java.util.Map;

public class HttpUtil {

    public static Map<String, Object> buildResponse(HttpCodeEnum httpStatusEnum, Object result) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", httpStatusEnum.getCode());
        response.put("message", httpStatusEnum.getMessage());
        response.put("result", result);
        return response;
    }
}
