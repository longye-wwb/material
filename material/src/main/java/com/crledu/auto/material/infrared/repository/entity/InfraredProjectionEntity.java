package com.crledu.auto.material.infrared.repository.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.crledu.auto.material.base.entity.AbstractMaterialEntity;

/**
 ************************************************************
 * @Description: 红外反射微波透射数据实体
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/7 14:14
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@TableName("at_infrared_projection")
public class InfraredProjectionEntity extends AbstractMaterialEntity {

    @TableId
    private Long id;

    /**
     * 基底材料
     */
    private String baseMaterial;

    /**
     * 基底介电常数
     */
    private Float baseDielectric;

    /**
     * 基底红外发射率
     */
    private Float baseEmissivity;

    /**
     * 基底厚度
     */
    private Float baseThickness;

    /**
     * 金属贴片层材料
     */
    private String patchMaterial;

    /**
     * 金属贴片红外发射率
     */
    private Float patchEmissivity;

    /**
     * 金属贴片周期
     */
    private Float patchPeriod;

    /**
     * 金属贴片宽度
     */
    private Float patchWidth;

    /**
     * 金属贴片厚度
     */
    private Float patchThickness;

    /**
     * 金属贴片占空比
     */
    private Float patchPercent;

    /**
     * 透射层红外发射率
     */
    private Float emissivity;

    /**
     * 入射角
     */
    private Float lightAngle;

    /**
     * 透射指标数据文件
     */
    private String projectionData;

    /**
     * 当前数据类型
     */
    private Integer curStatus;

    public InfraredProjectionEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Float getBaseEmissivity() {
        return baseEmissivity;
    }

    public void setBaseEmissivity(Float baseEmissivity) {
        this.baseEmissivity = baseEmissivity;
    }

    public Float getBaseThickness() {
        return baseThickness;
    }

    public void setBaseThickness(Float baseThickness) {
        this.baseThickness = baseThickness;
    }

    public String getPatchMaterial() {
        return patchMaterial;
    }

    public void setPatchMaterial(String patchMaterial) {
        this.patchMaterial = patchMaterial;
    }

    public Float getPatchEmissivity() {
        return patchEmissivity;
    }

    public void setPatchEmissivity(Float patchEmissivity) {
        this.patchEmissivity = patchEmissivity;
    }

    public Float getPatchPeriod() {
        return patchPeriod;
    }

    public void setPatchPeriod(Float patchPeriod) {
        this.patchPeriod = patchPeriod;
    }

    public Float getPatchWidth() {
        return patchWidth;
    }

    public void setPatchWidth(Float patchWidth) {
        this.patchWidth = patchWidth;
    }

    public Float getPatchPercent() {
        return patchPercent;
    }

    public void setPatchPercent(Float patchPercent) {
        this.patchPercent = patchPercent;
    }

    public Float getEmissivity() {
        return emissivity;
    }

    public void setEmissivity(Float emissivity) {
        this.emissivity = emissivity;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }

    public String getProjectionData() {
        return projectionData;
    }

    public void setProjectionData(String projectionData) {
        this.projectionData = projectionData;
    }

    public Integer getCurStatus() {
        return curStatus;
    }

    public void setCurStatus(Integer curStatus) {
        this.curStatus = curStatus;
    }
}
