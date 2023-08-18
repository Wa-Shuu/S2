package com.washuu.s2.util;

import com.washuu.s2.util.Enum.RespEnum;
import com.washuu.s2.util.Enum.Result;

public class ResultUtil {

    /**成功且带数据**/
    public static Result<Object> success(Object object){
        Result<Object> result = new Result<Object>();
        result.setValue(RespEnum.SUCCESS.getValue());
        result.setMsg(object);
        return result;
    }
    /**成功但不带数据**/
    public static Result<Object> success(){

        return success(null);
    }
    /**错误**/
    public static Result<String> error(String msg){
        Result<String> result = new Result<String>();
        result.setValue(RespEnum.ERROR.getValue());
        result.setMsg(msg);
        return result;
    }

    /**失败**/
    public static Result<String> failed(String msg){
        Result<String> result = new Result<String>();
        result.setValue(RespEnum.FAILED.getValue());
        result.setMsg(msg);
        return result;
    }
}
