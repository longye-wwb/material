package com.crledu.auto.material.antenna.api.vo;

import com.crledu.auto.material.base.vo.ImportFormdataVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 纳米天线导入参数
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 15:54
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("纳米天线导入参数")
public class AntennaImportFormVo extends ImportFormdataVo {

    @ApiModelProperty("天线材料")
    private String material;

    @ApiModelProperty("天线类型")
    private Integer type;

    @ApiModelProperty("天线介电常数")
    private Float constant;

    @ApiModelProperty("基底材料")
    private String baseMaterial;

    @ApiModelProperty("基底类型")
    private Integer baseType;

    @ApiModelProperty("基底介电常数")
    private Float baseConstant;

    @ApiModelProperty("光源类型")
    private Integer lightType;

    @ApiModelProperty("工作方式")
    private Integer workingMode;



    public AntennaImportFormVo() {
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Float getConstant() {
        return constant;
    }

    public void setConstant(Float constant) {
        this.constant = constant;
    }

    public String getBaseMaterial() {
        return baseMaterial;
    }

    public void setBaseMaterial(String baseMaterial) {
        this.baseMaterial = baseMaterial;
    }

    public Integer getBaseType() {
        return baseType;
    }

    public void setBaseType(Integer baseType) {
        this.baseType = baseType;
    }

    public Float getBaseConstant() {
        return baseConstant;
    }

    public void setBaseConstant(Float baseConstant) {
        this.baseConstant = baseConstant;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public Integer getWorkingMode() {
        return workingMode;
    }

    public void setWorkingMode(Integer workingMode) {
        this.workingMode = workingMode;
    }
}
