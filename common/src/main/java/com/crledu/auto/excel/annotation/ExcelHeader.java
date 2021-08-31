package com.crledu.auto.excel.annotation;

import com.crledu.auto.excel.dto.ExcelSettings;

import java.lang.annotation.*;

/**
 ************************************************************
 * @Description: excel文件导出工具注解-表头
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/4/12 16:03
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelHeader {

    String name() default "";
    String date() default "";
    int begin() default ExcelSettings.DEFAULT_BEGIN_ROW;
}
