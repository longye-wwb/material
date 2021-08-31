package com.crledu.auto.material.grating.data.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 红外窄带传感材料基础数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/4 17:48
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel(" 红外窄带传感材料基础数据")
public class InfraredGratingItemDto {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("入射角")
    private Float lightAngle;

    @ApiModelProperty("微结构宽")
    private Float width;

    @ApiModelProperty("微结构高")
    private Float height;

    @ApiModelProperty("边缘间距")
    private Float spaces;

    @ApiModelProperty("数据导入历史")
    private Long importId;

    @ApiModelProperty("数据来源")
    private Integer dataFrom;

    @ApiModelProperty("光源类型")
    private Integer lightType;

    @ApiModelProperty("材料")
    private String material;

    @ApiModelProperty("相对带宽")
    private Float bandwidth;

    public InfraredGratingItemDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getSpaces() {
        return spaces;
    }

    public void setSpaces(Float spaces) {
        this.spaces = spaces;
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

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Float getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Float bandwidth) {
        this.bandwidth = bandwidth;
    }
}
