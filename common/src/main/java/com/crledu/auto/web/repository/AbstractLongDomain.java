package com.crledu.auto.web.repository;

/**
 ************************************************************
 * @Description: long 作为主键的业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/3 10:49
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public abstract class AbstractLongDomain {

    /**
     * 主键
     */
    private Long id;

    /**
     * 状态
     */
    private Integer status;

    public AbstractLongDomain(Long id, Integer status) {
        this.id = id;
        this.status = status;
    }

    protected boolean beSaved(){
        return this.id != null;
    }

    public Long getId() {
        return id;
    }

    public Integer getStatus() {
        return status;
    }
}
