package com.crledu.auto.code.config;

import com.crledu.auto.code.field.FieldConfig;

import java.util.List;

/**
 ************************************************************
 * @Description: 业务实体的配置
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/2/5 16:57
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class EntityConfig {

    /**
     * 实体名称
     */
    private String name;

    /**
     * 数据表名称
     */
    private String table;

    /**
     * 编码负责人
     */
    private String author;

    /**
     * 编码版本
     */
    private String version;

    /**
     * 功能属性列表
     */
    private List<FieldConfig> fields;

    public EntityConfig() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<FieldConfig> getFields() {
        return fields;
    }

    public void setFields(List<FieldConfig> fields) {
        this.fields = fields;
    }
}
