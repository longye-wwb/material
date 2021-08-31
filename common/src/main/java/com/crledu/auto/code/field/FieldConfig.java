package com.crledu.auto.code.field;

/**
 ************************************************************
 * @Description: 实体属性配置
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/2/5 16:32
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class FieldConfig {

    /**
     * 字段名
     */
    private String name;

    /**
     * 字段类型
     */
    private FieldTypes type;

    /**
     * 字段长度
     */
    private Integer length;

    /**
     * 是否是组件
     */
    private Boolean isKey;

    /**
     * 属性注释
     */
    private String desc;

    /**
     * 属性长度检查
     */
    private Integer min;

    /**
     * 属性为空检查
     */
    private Boolean required;

    public FieldConfig() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FieldTypes getType() {
        return type;
    }

    public void setType(FieldTypes type) {
        this.type = type;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Boolean getKey() {
        return isKey;
    }

    public void setKey(Boolean key) {
        isKey = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }
}
