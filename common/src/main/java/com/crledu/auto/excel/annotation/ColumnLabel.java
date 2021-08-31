package com.crledu.auto.excel.annotation;

import com.crledu.auto.excel.dto.ColumnSettings;

import java.lang.annotation.*;

/**
 ************************************************************
 * @Description: 表格列属性
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/4/12 15:52
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ColumnLabel {

    String name() default "";
    int index() default ColumnSettings.DEFAULT_COLUMN_INDEX;
}
