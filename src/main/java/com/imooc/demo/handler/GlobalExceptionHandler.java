package com.imooc.demo.handler;

import com.imooc.demo.Constants.Constant;
import com.imooc.demo.utils.DataEncapUtil;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String,Object> exceptionHandler(HttpServletRequest req, Exception e){
        Map<String, Object> modelMap = DataEncapUtil.getModeMap();
        modelMap.put("code", Constant.DATA_CODE_FAILURE);
        modelMap.put("msg",e.getMessage());
        modelMap.put("data", null);
        return modelMap;
    }
}
