package com.crledu.auto.material.base.service.annotation;

import java.lang.annotation.*;

/**
 ************************************************************
 * @Description: 用于对应属性在表格中的列名
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/30 15:17
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ColumnName {

    String value();
}
