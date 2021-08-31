package com.crledu.auto.util;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 ************************************************************
 * @Description: 产出Map的相关工具方法
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/2 9:28
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class MapUtils {

    /**
     *****************************************************************************
     * @Description 使用对象
     *****************************************************************************
     * @Param [obj]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/12/2 9:31
     *****************************************************************************
     **/
    public static Map<String, Object> getObjectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Class<?> clazz = obj.getClass();
        System.out.println(clazz);
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            if (value == null){
                value = "";
            }
            map.put(fieldName, value);
        }
        return map;
    }

}
