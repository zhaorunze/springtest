package com.imooc.demo.utils;

import com.imooc.demo.Constants.Constant;

import java.util.HashMap;
import java.util.Map;

public class DataEncapUtil {

    public static Map<String, Object> encap(Object data){
        Map<String,Object> result = new HashMap<>();
        result.put("code", Constant.DATA_CODE_SUCCESS);
        result.put("msg", Constant.DATA_MSG_DEFAULT);
        result.put("data", data);
        return result;
    }

    public static Map<String,Object> getModeMap(){
        return new HashMap<>();
    }
}
