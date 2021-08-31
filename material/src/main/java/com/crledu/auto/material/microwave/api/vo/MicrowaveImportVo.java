package com.crledu.auto.material.microwave.api.vo;

import com.crledu.auto.web.response.Response;
import io.swagger.annotations.ApiModelProperty;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/10
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class MicrowaveImportVo {

    //结构材料
    @ApiModelProperty(value = "结构材料")
    private Integer materialStructure;
    //填充材料
    @ApiModelProperty(value ="填充材料")
    private Integer filler;
    @ApiModelProperty(value = "数据来源")
    private Integer dataFrom;
    @ApiModelProperty(value = "入射光源类型")
    private Integer lightType;
    @ApiModelProperty(value = "入射角度")
    private Float lightAngle;
    @ApiModelProperty(value = "工作方式")
    private Integer workType;

    public Integer getMaterialStructure() {
        return materialStructure;
    }

    public void setMaterialStructure(Integer materialStructure) {
        this.materialStructure = materialStructure;
    }

    public Integer getFiller() {
        return filler;
    }

    public void setFiller(Integer filler) {
        this.filler = filler;
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

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }
}
