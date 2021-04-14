package com.onestep.mall.config;

import cn.dev33.satoken.exception.NotLoginException;
import com.onestep.mall.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobeExceptionHandle {
    // 全局异常拦截（拦截项目中的NotLoginException异常） 应对未登陆的问题
    @ExceptionHandler(NotLoginException.class)
    public Result<String> handlerNotLoginException(NotLoginException nle, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // 打印堆栈，以供调试
        //nle.printStackTrace();

        // 判断场景值，定制化异常信息
        String message = "";
        switch (nle.getType()) {
            case NotLoginException.NOT_TOKEN:
                message = "未提供token";
                break;
            case NotLoginException.INVALID_TOKEN:
                message = "token无效";
                break;
            case NotLoginException.TOKEN_TIMEOUT:
                message = "token已过期";
                break;
            case NotLoginException.BE_REPLACED:
                message = "token已被顶下线";
                break;
            case NotLoginException.KICK_OUT:
                message = "token已被踢下线";
                break;
            default:
                message = "当前会话未登录";
                break;
        }

        // 返回给前端
        return new Result<>(416,message);
    }
}
