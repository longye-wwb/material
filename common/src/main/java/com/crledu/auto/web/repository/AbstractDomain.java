package com.crledu.auto.web.repository;

import com.crledu.auto.util.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 ************************************************************
 * @Description: 统一的业务对象格式
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/4/2 15:53
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public abstract class AbstractDomain<IDTYPE> {

    protected static final Integer CREATED = 1;
    protected static final Integer DELETED = 20;

    private Date createTime;
    private Date updateTime;

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    private IDTYPE id;
    private Integer statu;

    public AbstractDomain(Date createTime, Date updateTime, IDTYPE id, Integer statu) {
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.id = id;
        this.statu = statu;
    }

    protected AbstractDomain() {
        this.statu = 1;
        this.createTime = new Date();
    }

    public Boolean beEntity(){
        return ObjectUtils.isNotNull(id);
    }

    public IDTYPE getId() {
        return id;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.updateTime = new Date();
        if(beEntity()){
            this.statu = statu;
        }else{
            log.warn("domain con`t change status when didn't save in database.",this.getClass().getCanonicalName());
            this.statu = statu;
        }
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
}
