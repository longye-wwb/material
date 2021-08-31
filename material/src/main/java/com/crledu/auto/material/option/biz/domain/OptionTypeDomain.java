package com.crledu.auto.material.option.biz.domain;

import com.crledu.auto.web.exception.RestRuntimeException;

import java.util.List;

/**
 ************************************************************
 * @Description: 离散化参数类型
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/18 11:58
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class OptionTypeDomain {

    /**
     * 主键
     */
    private Long id;

    /**
     * 编号
     */
    private Integer value;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 添加下拉选选项
     */
    private List<OptionDomain> optionDomains;

    /**
     * 状态
     */
    private Integer status;

    private OptionTypeDomain(Integer value, String code, String name) {
        this.value = value;
        this.code = code;
        this.name = name;
    }

    public OptionTypeDomain(Long id, Integer value, String code, String name, Integer status) {
        this.id = id;
        this.value = value;
        this.code = code;
        this.name = name;
        this.status = status;
    }

    public OptionDomain createOption(String code,String name){
        OptionDomain optionDomain = OptionDomain.getInstance(this.id,code,name);
        for(OptionDomain item : this.optionDomains){
            if(item.getCode().trim().equals(optionDomain.getCode().trim())){
                throw new RestRuntimeException("1000000101","重复添加选项编码");
            }
        }
        this.optionDomains.add(optionDomain);
        return optionDomain;
    }

    public Long getId() {
        return id;
    }

    public Integer getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Integer getStatus() {
        return status;
    }

    public List<OptionDomain> getOptionDomains() {
        return optionDomains;
    }
}
