package com.crledu.auto.material.second.repository.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.crledu.auto.material.base.entity.AbstractMaterialEntity;

/**
 ************************************************************
 * @Description: 衍射组件数据库实体
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/13 10:13
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@TableName("se_diffraction")
public class DiffractionEntity extends AbstractMaterialEntity {

    @TableId
    private Long id;

    private String dataStr;

    /**
     * 入射波长
     */
    private float inLine;

    /**
     * 材料周期
     */
    private float period;

    /**
     * 材料折射率
     */
    private float refractive;

    /**
     * 基底折射率
     */
    private float BaseRefractive;

    /**
     * 衍射角
     */
    private float angle;

    /**
     * 衍射阶数
     */
    private int order1;

    /**
     * 组件结构图地址
     */
    private String picture;

    /**
     * 衍射效果图
     */
    private String diffraction;

    private Integer curStatus;

    public DiffractionEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getInLine() {
        return inLine;
    }

    public void setInLine(float inLine) {
        this.inLine = inLine;
    }

    public float getPeriod() {
        return period;
    }

    public void setPeriod(float period) {
        this.period = period;
    }

    public float getRefractive() {
        return refractive;
    }

    public void setRefractive(float refractive) {
        this.refractive = refractive;
    }

    public float getBaseRefractive() {
        return BaseRefractive;
    }

    public void setBaseRefractive(float baseRefractive) {
        BaseRefractive = baseRefractive;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public String getDataStr() {
        return dataStr;
    }

    public void setDataStr(String dataStr) {
        this.dataStr = dataStr;
    }

    public int getOrder1() {
        return order1;
    }

    public void setOrder1(int order1) {
        this.order1 = order1;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDiffraction() {
        return diffraction;
    }

    public void setDiffraction(String diffraction) {
        this.diffraction = diffraction;
    }

    public Integer getCurStatus() {
        return curStatus;
    }

    public void setCurStatus(Integer curStatus) {
        this.curStatus = curStatus;
    }
}
