package com.crledu.auto.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 ************************************************************
 * @Description: 时间处理工具方法集合
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/6/30 16:57
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class DateUtils {
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String FILE_PATTERN = "yyyyMMddHHmmss";


    /**
     *****************************************************************************
     * @Description 按照系统时区将时间转为字符串
     *****************************************************************************
     * @Param [date, pattern]
     * @return java.lang.String
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/6/30 17:30
     *****************************************************************************
     **/
    public static String convertDateToString(Date date, String pattern ){
        if(pattern == null || pattern.trim().isEmpty()){
            pattern = DEFAULT_PATTERN;
        }
        SimpleDateFormat formatte = new SimpleDateFormat(pattern);
        return formatte.format(date);
    }

    public static Date convertStringTODate(String timeString,String pattern) throws ParseException {
        if(pattern == null || pattern.trim().isEmpty()){
            pattern = DEFAULT_PATTERN;
        }
        SimpleDateFormat formatte = new SimpleDateFormat(pattern);
        return formatte.parse(timeString);
    }

    /**
     *****************************************************************************
     * @Description 获取当前的时间的日期字符串 默认格式为：yyyy-MM-dd
     *****************************************************************************
     * @Param [pattern]
     * @return java.lang.String
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/3 11:51
     *****************************************************************************
     **/
    public static String getTodayDateString(String pattern){
        Date date = new Date();
        if(pattern == null || pattern.trim().isEmpty()){
            pattern = DEFAULT_DATE_PATTERN;
        }
        return convertDateToString(date,pattern);
    }

    /**
     *****************************************************************************
     * @Description 获取日期当天的第一微秒
     *****************************************************************************
     * @Param [date]
     * @return java.util.Date
     *****************************************************************************
     * @Author wenyi
     * @Date 2021/4/13 9:29
     *****************************************************************************
     **/
    public static Date toFirstSecond(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTime();
    }

    /**
     *****************************************************************************
     * @Description 获取日期的最后一微秒
     *****************************************************************************
     * @Param [date]
     * @return java.util.Date
     *****************************************************************************
     * @Author wenyi
     * @Date 2021/4/13 9:30
     *****************************************************************************
     **/
    public static Date toLastSecond(Date date){
        date = toFirstSecond(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.MILLISECOND,-1);
        return calendar.getTime();
    }
}
