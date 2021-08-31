package com.crledu.auto.code.field;

/**
 ************************************************************
 * @Description: 用于指导代码拼接的数据类型转换
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/2/5 16:27
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public enum FieldTypes {
    INTEGER("Integer","int",""),
    STRING("String","varchar",""),
    LONG("Long","bigint",""),
    TEXT("String","text","");

    private Long id;
    private String javaName;
    private String mysqlName;
    private String importName;
    private Integer length;

    FieldTypes(String javaName, String mysqlName, String importName) {
        this.javaName = javaName;
        this.mysqlName = mysqlName;
        this.importName = importName;
    }
}
