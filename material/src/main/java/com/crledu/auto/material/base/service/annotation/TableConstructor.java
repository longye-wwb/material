package com.crledu.auto.material.base.service.annotation;

import java.lang.annotation.*;

/**
 ************************************************************
 * @Description: 标识表格构造参数注解
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/30 16:00
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TableConstructor {
}
