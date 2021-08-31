package com.crledu.auto.material.infrared.api.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 微波吸收层内部层相应参数
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/23 18:04
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("组成微波吸收层的参数")
public class LayerItemVo {

    @ApiModelProperty("基底材料")
    private String baseMaterial;

    @ApiModelProperty("基底材料介电常数")
    private Float baseDielectricConstant;

    @ApiModelProperty("介质层材料")
    private String dielectricMaterial;

    @ApiModelProperty("介质层材料介电常数")
    private Float dielectricConstant;

    @ApiModelProperty("形状")
    private Integer shape;

    public LayerItemVo() {
    }

    public String getBaseMaterial() {
        return baseMaterial;
    }

    public void setBaseMaterial(String baseMaterial) {
        this.baseMaterial = baseMaterial;
    }

    public Float getBaseDielectricConstant() {
        return baseDielectricConstant;
    }

    public void setBaseDielectricConstant(Float baseDielectricConstant) {
        this.baseDielectricConstant = baseDielectricConstant;
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

    public Integer getShape() {
        return shape;
    }

    public void setShape(Integer shape) {
        this.shape = shape;
    }
}
