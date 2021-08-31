package com.crledu.auto.material.microw.api.vo;

import com.crledu.auto.material.base.vo.ImportFormdataVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 微波宽带相位调控表单参数
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/11 10:49
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("微波宽带相位调控表单参数")
public class MicrowavePhaseImportFormVo extends ImportFormdataVo {

    /**
     * 金属厚度
     */
    @ApiModelProperty("金属厚度")
    private Float thickness;

    /**
     * 工作方式
     */
    @ApiModelProperty("工作方式")
    private Integer workingMode;

    @ApiModelProperty("入射光源类型")
    private Integer lightType;

    //TODO

    public MicrowavePhaseImportFormVo() {
    }

    public Float getThickness() {
        return thickness;
    }

    public void setThickness(Float thickness) {
        this.thickness = thickness;
    }

    public Integer getWorkingMode() {
        return workingMode;
    }

    public void setWorkingMode(Integer workingMode) {
        this.workingMode = workingMode;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }
}
