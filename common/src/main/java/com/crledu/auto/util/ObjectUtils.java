package com.crledu.auto.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;

public class ObjectUtils {

    public static boolean isNull(Object o){
        if(o == null){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isNotNull(Object o){
        return !isNull(o);
    }

    public static Object getValueByString(Type type,String str){
        if(type.getTypeName() == Integer.class.getTypeName()){
            if(str.isEmpty()){
                return null;
            }
            return Integer.parseInt(str);
        }else if(type.getTypeName() == Float.class.getTypeName()){
            if(str.isEmpty()){
                return null;
            }
            return Float.valueOf(str);
        }else if(type.getTypeName() == Double.class.getTypeName()){
            if(str.isEmpty()){
                return null;
            }
            return Double.parseDouble(str);
        }else{
            return str;
        }
    }

    /**
     *****************************************************************************
     * @Description 使用map实例化对象
     *****************************************************************************
     * @Param [map, beanClass]
     * @return java.lang.Object
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/12/2 9:30
     *****************************************************************************
     **/
    public static Object mapToObject(Map<Object, Object> map, Class<?> beanClass) throws Exception {
        if (map == null){
            return null;
        }
        Object obj = beanClass.newInstance();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }
            field.setAccessible(true);
            if (map.containsKey(field.getName())) {
                field.set(obj, map.get(field.getName()));
            }
        }
        return obj;
    }

    }
