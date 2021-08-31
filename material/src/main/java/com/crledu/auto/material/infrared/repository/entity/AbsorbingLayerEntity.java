package com.crledu.auto.material.infrared.repository.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 ************************************************************
 * @Description: 微波吸收层组成单元实体
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/26 17:59
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/

@TableName("at_ma_layer")
public class AbsorbingLayerEntity {

    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 所属微波吸收层主键
     */
    private Long LayerId;

    /**
     * 序号
     */
    private Integer ord;

    /**
     * 电阻形状
     */
    private Integer shape;

    /**
     * 电阻边长
     */
    private Float side;

    /**
     * 电阻值
     */
    private Float resistance;

    /**
     * 基底材料
     */
    private String baseMaterial;

    /**
     * 基底介电常数
     */
    private Float baseDielectric;

    /**
     * 介质层材料
     */
    private String dielectricMaterial;

    /**
     * 介质层介电常数
     */
    private Float dielectricConstant;

    /**
     * 介质层厚度
     */
    private Float thickness;

    /**
     * 数据状态
     */
    private Integer curStatus;

    public AbsorbingLayerEntity() {
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
