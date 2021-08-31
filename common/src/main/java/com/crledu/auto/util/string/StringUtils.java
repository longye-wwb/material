package com.crledu.auto.util.string;

import com.crledu.auto.util.ObjectUtils;

public class StringUtils {

    public static final String EMPTY_STRING = "";


    /**
     *****************************************************************************
     * @Description 判断字符串,去掉首尾的空格后是不是 null "".
     *****************************************************************************
     * @Param [str]
     * @return java.lang.Boolean
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/20 10:49
     *****************************************************************************
     **/
    public static Boolean isEmpty(String str){
       return !isNotEmpty(str);
    }

    /**
     *****************************************************************************
     * @Description 判断字符串,去掉首尾的空格后是不是 null "".
     *****************************************************************************
     * @Param [str]
     * @return java.lang.Boolean
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/20 10:49
     *****************************************************************************
     **/
    public static Boolean isNotEmpty(String str){
        if(ObjectUtils.isNotNull(str) && !str.trim().isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static Boolean IsNullOrWhiteSpace(String str){
        if(str == null){
            return true;
        }else if(str.trim().isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
