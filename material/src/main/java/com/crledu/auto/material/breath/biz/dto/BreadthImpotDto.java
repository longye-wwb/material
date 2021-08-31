package com.crledu.auto.material.breath.biz.dto;

import com.crledu.auto.material.base.dto.ImportItemFormData;
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
public class BreadthImpotDto extends ImportItemFormData {


    //入射角
    @ApiModelProperty(value = "入射角")
    private Float lightAngle;
    //类型
    @ApiModelProperty(value = "结构材料类型")
    private Integer type;
    //材料
    @ApiModelProperty(value = "结构材料")
    private String structureMaterial;
    //厚度 d
    @ApiModelProperty(value = "结构材料厚度")
    private Float structureThickness;

    //材料
    @ApiModelProperty(value = "基底材料")
    private String baseMaterial;
    //厚度 t1
    @ApiModelProperty(value = "基底厚度")
    private Float baseThickness;

    //材料
    @ApiModelProperty(value = "介质材料")
    private String mediumMaterial;
    //介电常数
    @ApiModelProperty(value = "介电常数")
    private Float dielectric;
    //损耗正切
    @ApiModelProperty(value = "损耗正切")
    private Float loss;

    private Integer lightType;

    private Integer workMode;


    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStructureMaterial() {
        return structureMaterial;
    }

    public void setStructureMaterial(String structureMaterial) {
        this.structureMaterial = structureMaterial;
    }

    public Float getStructureThickness() {
        return structureThickness;
    }

    public void setStructureThickness(Float structureThickness) {
        this.structureThickness = structureThickness;
    }

    public String getBaseMaterial() {
        return baseMaterial;
    }

    public void setBaseMaterial(String baseMaterial) {
        this.baseMaterial = baseMaterial;
    }

    public Float getBaseThickness() {
        return baseThickness;
    }

    public void setBaseThickness(Float baseThickness) {
        this.baseThickness = baseThickness;
    }

    public String getMediumMaterial() {
        return mediumMaterial;
    }

    public void setMediumMaterial(String mediumMaterial) {
        this.mediumMaterial = mediumMaterial;
    }

    public Float getDielectric() {
        return dielectric;
    }

    public void setDielectric(Float dielectric) {
        this.dielectric = dielectric;
    }

    public Float getLoss() {
        return loss;
    }

    public void setLoss(Float loss) {
        this.loss = loss;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public Integer getWorkMode() {
        return workMode;
    }

    public void setWorkMode(Integer workMode) {
        this.workMode = workMode;
    }
}
