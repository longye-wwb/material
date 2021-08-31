package com.crledu.auto.material.breath.api.vo;

import com.crledu.auto.web.view.PageParamVO;
import com.crledu.auto.web.vo.number.FloatParamVo;
import com.crledu.auto.web.vo.StringParamVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/8
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class BreadthSelectListVo  extends PageParamVO {
    //入射角
    @ApiModelProperty(value = "入射角")
    private FloatParamVo lightAngle;
    //类型
    @ApiModelProperty(value = "结构材料类型")
    private Integer type;
    //材料
    @ApiModelProperty(value = "结构材料")
    private StringParamVo structureMaterial;
    //厚度 d
    @ApiModelProperty(value = "结构材料厚度")
    private FloatParamVo structureThickness;

    //材料
    @ApiModelProperty(value = "基底材料")
    private StringParamVo BaseMaterial;
    //厚度 t1
    @ApiModelProperty(value = "基底厚度")
    private FloatParamVo baseThickness;

    //材料
    @ApiModelProperty(value = "介质材料")
    private StringParamVo MediumMaterial;
    //介电常数
    @ApiModelProperty(value = "介电常数")
    private FloatParamVo dielectric;
    //损耗正切
    @ApiModelProperty(value = "损耗正切")
    private FloatParamVo loss;

    @ApiModelProperty(value = "光源类型")
    private Integer lightType;

    @ApiModelProperty(value = "工作方式")
    private Integer workMode;

    @ApiModelProperty(value = "相对带宽")
    private FloatParamVo bandwidth;

    public FloatParamVo getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(FloatParamVo lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public StringParamVo getStructureMaterial() {
        return structureMaterial;
    }

    public void setStructureMaterial(StringParamVo structureMaterial) {
        this.structureMaterial = structureMaterial;
    }

    public FloatParamVo getStructureThickness() {
        return structureThickness;
    }

    public void setStructureThickness(FloatParamVo structureThickness) {
        this.structureThickness = structureThickness;
    }

    public StringParamVo getBaseMaterial() {
        return BaseMaterial;
    }

    public void setBaseMaterial(StringParamVo baseMaterial) {
        BaseMaterial = baseMaterial;
    }

    public FloatParamVo getBaseThickness() {
        return baseThickness;
    }

    public void setBaseThickness(FloatParamVo baseThickness) {
        this.baseThickness = baseThickness;
    }

    public StringParamVo getMediumMaterial() {
        return MediumMaterial;
    }

    public void setMediumMaterial(StringParamVo mediumMaterial) {
        MediumMaterial = mediumMaterial;
    }

    public FloatParamVo getDielectric() {
        return dielectric;
    }

    public void setDielectric(FloatParamVo dielectric) {
        this.dielectric = dielectric;
    }

    public FloatParamVo getLoss() {
        return loss;
    }

    public void setLoss(FloatParamVo loss) {
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

    public FloatParamVo getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(FloatParamVo bandwidth) {
        this.bandwidth = bandwidth;
    }
}
