package com.crledu.auto.util.string;

import java.text.DecimalFormat;

public class NumberUtils {

    public static String formatNumber(Integer value,String pattern){
        if(pattern == null || pattern.isEmpty()){
            pattern="0000.00";
        }
        DecimalFormat format = new DecimalFormat(pattern);
        return format.format(value);

    }

    public static Integer parseFormatIntegerValue(String str){
        return  Integer.valueOf(str);
    }
}
