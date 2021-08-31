package com.crledu.auto.material.infrared.api.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/2
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class MicrowaveAbsorbingLayerVo {

    @ApiModelProperty(value = "数据库主键")
    private Long id;

    @ApiModelProperty(value = "所属微波层主键")
    private Long LayerId;

    @ApiModelProperty(value ="序号")
    private Integer ord;

    /**
     * 电阻形状
     */
    @ApiModelProperty(value = "电阻形状")
    private Integer shape;
    /**
     * 电阻边长
     */
    @ApiModelProperty(value = "电阻边长")
    private Float side;

    /**
     * 电阻值
     */
    @ApiModelProperty(value = "电阻值")
    private Float resistance;

    /**
     * 基底材料
     */
    @ApiModelProperty(value ="基底材料")
    private String baseMaterial;

    /**
     * 基底介电常数
     */
    @ApiModelProperty(value = "基底介电常数")
    private Float baseDielectric;

    /**
     * 介质层材料
     */
    @ApiModelProperty(value = "介质层材料")
    private String dielectricMaterial;

    /**
     * 介质层介电常数
     */
    @ApiModelProperty(value = "介质层介电常数")
    private Float dielectricConstant;

    /**
     * 介质层厚度
     */
    @ApiModelProperty(value = "介质层厚度")
    private Float thickness;

    /**
     * 数据状态
     */
    @ApiModelProperty(value = "数据状态")
    private Integer curStatus;

    public MicrowaveAbsorbingLayerVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLayerId() {
        return LayerId;
    }

    public void setLayerId(Long layerId) {
        LayerId = layerId;
    }

    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }

    public Integer getShape() {
        return shape;
    }

    public void setShape(Integer shape) {
        this.shape = shape;
    }

    public Float getSide() {
        return side;
    }

    public void setSide(Float side) {
        this.side = side;
    }

    public Float getResistance() {
        return resistance;
    }

    public void setResistance(Float resistance) {
        this.resistance = resistance;
    }

    public String getBaseMaterial() {
        return baseMaterial;
    }

    public void setBaseMaterial(String baseMaterial) {
        this.baseMaterial = baseMaterial;
    }

    public Float getBaseDielectric() {
        return baseDielectric;
    }

    public void setBaseDielectric(Float baseDielectric) {
        this.baseDielectric = baseDielectric;
    }

    public String getDielectricMaterial() {
        return dielectricMaterial;
    }

    public void setDielectricMaterial(String dielectricMaterial) {
        this.dielectricMaterial = dielectricMaterial;
    }

    public Float getDielectricConstant() {
        return dielectricConstant;
    }

    public void setDielectricConstant(Float dielectricConstant) {
        this.dielectricConstant = dielectricConstant;
    }

    public Float getThickness() {
        return thickness;
    }

    public void setThickness(Float thickness) {
        this.thickness = thickness;
    }

    public Integer getCurStatus() {
        return curStatus;
    }

    public void setCurStatus(Integer curStatus) {
        this.curStatus = curStatus;
    }
}
