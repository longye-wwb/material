package com.crledu.auto.material.infrared.api.vo;

import com.crledu.auto.util.ObjectUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 微波吸收层功能属性导入参数
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/23 17:53
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("微波吸收层功能属性导入参数")
public class MicrowaveAbsorbingLayerImportVo {

    /**
     * 周期
     */
    @ApiModelProperty("周期")
    private Float period;

    @ApiModelProperty(value = "功能层1基底材料",required = true)
    private String baseMaterial;

    @ApiModelProperty(value = "功能层1基底材料介电常数",required = true)
    private Float baseDielectricConstant;

    @ApiModelProperty(value = "功能层1介质层材料",required = true)
    private String dielectricMaterial;

    @ApiModelProperty(value = "功能层1介质层材料介电常数",required = true)
    private Float dielectricConstant;

    @ApiModelProperty(value = "功能层1形状",required = true)
    private Integer shape;

    @ApiModelProperty("功能层2基底材料")
    private String baseMaterial2;

    @ApiModelProperty("功能层2基底材料介电常数")
    private Float baseDielectricConstant2;

    @ApiModelProperty("功能层2介质层材料")
    private String dielectricMaterial2;

    @ApiModelProperty("功能层2介质层材料介电常数")
    private Float dielectricConstant2;

    @ApiModelProperty("功能层2形状")
    private Integer shape2;

    /**
     * 组成层结构
     */
    @ApiModelProperty("组成层结构")
    private List<LayerItemVo> layerItemVos;

    /**
     * 数据来源
     */
    @ApiModelProperty("数据来源")
    private Integer dataFrom;

    /**
     * 入射角
     */
    @ApiModelProperty("入射角")
    private Float lightAngle;

    public MicrowaveAbsorbingLayerImportVo() {
    }

    public Float getPeriod() {
        return period;
    }

    public void setPeriod(Float period) {
        this.period = period;
    }

    public List<LayerItemVo> getLayerItemVos() {
        if(ObjectUtils.isNull(this.layerItemVos)){
            this.layerItemVos = new ArrayList<>();
            LayerItemVo itemVo1 = new LayerItemVo();
            itemVo1.setBaseDielectricConstant(baseDielectricConstant);
            itemVo1.setBaseMaterial(baseMaterial);
            itemVo1.setDielectricConstant(dielectricConstant);
            itemVo1.setDielectricMaterial(dielectricMaterial);
            itemVo1.setShape(shape);
            layerItemVos.add(itemVo1);
            if(ObjectUtils.isNotNull(shape2)){
                LayerItemVo itemVo2 = new LayerItemVo();
                itemVo2.setBaseDielectricConstant(baseDielectricConstant2);
                itemVo2.setBaseMaterial(baseMaterial2);
                itemVo2.setDielectricConstant(dielectricConstant2);
                itemVo2.setDielectricMaterial(dielectricMaterial2);
                itemVo2.setShape(shape2);
                layerItemVos.add(itemVo2);
            }
        }
        return layerItemVos;
    }

    public void setLayerItemVos(List<LayerItemVo> layerItemVos) {
        this.layerItemVos = layerItemVos;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
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

    public String getBaseMaterial2() {
        return baseMaterial2;
    }

    public void setBaseMaterial2(String baseMaterial2) {
        this.baseMaterial2 = baseMaterial2;
    }

    public Float getBaseDielectricConstant2() {
        return baseDielectricConstant2;
    }

    public void setBaseDielectricConstant2(Float baseDielectricConstant2) {
        this.baseDielectricConstant2 = baseDielectricConstant2;
    }

    public String getDielectricMaterial2() {
        return dielectricMaterial2;
    }

    public void setDielectricMaterial2(String dielectricMaterial2) {
        this.dielectricMaterial2 = dielectricMaterial2;
    }

    public Float getDielectricConstant2() {
        return dielectricConstant2;
    }

    public void setDielectricConstant2(Float dielectricConstant2) {
        this.dielectricConstant2 = dielectricConstant2;
    }

    public Integer getShape2() {
        return shape2;
    }

    public void setShape2(Integer shape2) {
        this.shape2 = shape2;
    }
}
