package com.crledu.auto.material.cooling.biz.domain;

/**
 ************************************************************
 * @Description: 膜或者柱材料数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/12 14:50
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class MaterailLayerDomain {

    /**
     * 层数
     */
    private Integer index;

    /**
     * 材料
     */
    private String materail;

    /**
     * 厚度、高度
     */
    private Float height;

    /**
     * 直径
     */
    private Float diameter;

    public MaterailLayerDomain() {
    }

    public MaterailLayerDomain(Integer index, String materail, Float height, Float diameter) {
        this.index = index;
        this.materail = materail;
        this.height = height;
        this.diameter = diameter;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setMaterail(String materail) {
        this.materail = materail;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public void setDiameter(Float diameter) {
        this.diameter = diameter;
    }

    public Integer getIndex() {
        return index;
    }

    public String getMaterail() {
        return materail;
    }

    public Float getHeight() {
        return height;
    }

    public Float getDiameter() {
        return diameter;
    }
}
