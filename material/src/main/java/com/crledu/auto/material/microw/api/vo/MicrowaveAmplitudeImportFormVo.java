package com.crledu.auto.material.microw.api.vo;

import com.crledu.auto.material.base.vo.ImportFormdataVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 微波偏振转换导入表单数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 16:05
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("微波偏振转换导入表单数据")
public class MicrowaveAmplitudeImportFormVo extends ImportFormdataVo {

    @ApiModelProperty("入射光偏振态")
    private Integer amplitudeType;

    @ApiModelProperty("工作方式")
    private Integer workingMode;

    public MicrowaveAmplitudeImportFormVo() {
    }

    public Integer getWorkingMode() {
        return workingMode;
    }

    public void setWorkingMode(Integer workingMode) {
        this.workingMode = workingMode;
    }

    public Integer getAmplitudeType() {
        return amplitudeType;
    }

    public void setAmplitudeType(Integer amplitudeType) {
        this.amplitudeType = amplitudeType;
    }
}
