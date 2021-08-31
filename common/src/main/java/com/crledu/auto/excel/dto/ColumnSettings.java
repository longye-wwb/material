package com.crledu.auto.excel.dto;

import java.lang.reflect.Method;

/**
 ************************************************************
 * @Description: 表格列设置
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/4/12 16:19
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ColumnSettings {

    public static final int DEFAULT_COLUMN_INDEX = 0;

    /**
     * 列名
     */
    private String name;

    /**
     * 列序号
     */
    private Integer index;

    /**
     * 获取值的方法
     */
    private Method getMethod;

    /**
     * 设置值的方法
     */
    private Method setMethod;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Method getGetMethod() {
        return getMethod;
    }

    public void setGetMethod(Method getMethod) {
        this.getMethod = getMethod;
    }

    public Method getSetMethod() {
        return setMethod;
    }

    public void setSetMethod(Method setMethod) {
        this.setMethod = setMethod;
    }
}
