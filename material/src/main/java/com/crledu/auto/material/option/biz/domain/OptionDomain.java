package com.crledu.auto.material.option.biz.domain;

/**
 ************************************************************
 * @Description: 选项业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/18 13:47
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class OptionDomain {

    /**
     * 主键
     */
    private Long id;

    /**
     * 选项类型
     */
    private Long type;

    /**
     * 选项编码
     */
    private String code;

    /**
     * 选项的中文名
     */
    private String label;

    /**
     * 选项的值
     */
    private Integer status;

    protected OptionDomain( Long type, String code, String label) {
        this.type = type;
        this.code = code;
        this.label = label;
        this.status = 1;
    }

    public static OptionDomain getInstance(Long type, String code, String label){
        return new OptionDomain(type, code, label);
    }

    public OptionDomain(Long id, Long type, String code, String label, Integer status) {
        this.id = id;
        this.type = type;
        this.code = code;
        this.label = label;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public Integer getStatus() {
        return status;
    }
}
