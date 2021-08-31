package com.crledu.auto.util.http;

import javax.servlet.http.HttpServletRequest;
/**
 ************************************************************
 * @Description: 用户请求的头信息处理工具
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/3 9:47
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class HeaderUtils {

    /**
     * app_key的参数名称
     */
    public static final String APPKEY_NAME = "appkey";

    /**
     * nonce的参数名称
     */
    public static final String NONCE_NAME = "nonce";

    /**
     * timen_stemp的参数名称
     */
    public static final String TIMENSTEMP_NAME = "timestemp";

    /**
     * accesstoken的参数名称
     */
    public static final String TOKEN_NAME = "accesstoken";

    /**
     * 接口签名的参数名称
     */
    public static final String SIGN_NAME = "sign";

    public static String getAppkey(HttpServletRequest request){
        return request.getHeader(APPKEY_NAME);
    }

    public static String getNonce(HttpServletRequest request){
        return request.getHeader(NONCE_NAME);
    }

    public static Long getTimeStemp(HttpServletRequest request){
        return request.getDateHeader(TIMENSTEMP_NAME);
    }

    public static String getToken(HttpServletRequest request){
        return request.getHeader(TOKEN_NAME);
    }

    public static String getSign(HttpServletRequest request){
        return request.getHeader(SIGN_NAME);
    }
}
