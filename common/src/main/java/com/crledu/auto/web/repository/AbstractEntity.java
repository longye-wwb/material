package com.crledu.auto.web.repository;

import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 ************************************************************
 * @Description: 系统数据实体
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/4/2 16:46
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class AbstractEntity<IDTYPE> {

    @TableId
    private IDTYPE id;

    private Date createTime;
    private Date updateTime;
    private Integer curStatus;

    public IDTYPE getId() {
        return id;
    }

    public void setId(IDTYPE id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCurStatus() {
        return curStatus;
    }

    public void setCurStatus(Integer curStatus) {
        this.curStatus = curStatus;
    }
}
