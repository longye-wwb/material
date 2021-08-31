package com.crledu.auto.material.second.repository.dto;

/**
 ************************************************************
 * @Description: 衍射组件
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/13 10:15
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class DiffractionDataDto {

    private Long importId;
    private Integer dataFrom;

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
    private int order;

    /**
     * 组件结构图地址
     */
    private String picture;

    /**
     * 衍射效果图
     */
    private float[][] diffraction;

    public DiffractionDataDto() {
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public float[][] getDiffraction() {
        return diffraction;
    }

    public void setDiffraction(float[][] diffraction) {
        this.diffraction = diffraction;
    }
}
