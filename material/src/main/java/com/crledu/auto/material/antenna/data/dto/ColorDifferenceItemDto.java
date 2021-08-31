package com.crledu.auto.material.antenna.data.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 消色差数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 16:07
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("消色差数据")
public class ColorDifferenceItemDto extends AntennaMaterialItemDto {

    @ApiModelProperty("群时延")
    private Float delayed;

    @ApiModelProperty("开始波长")
    private Float waveStart;

    @ApiModelProperty("结束波长")
    private Float waveEnd;

    public ColorDifferenceItemDto() {
    }

    public Float getDelayed() {
        return delayed;
    }

    public void setDelayed(Float delayed) {
        this.delayed = delayed;
    }

    public Float getWaveStart() {
        return waveStart;
    }

    public void setWaveStart(Float waveStart) {
        this.waveStart = waveStart;
    }

    public Float getWaveEnd() {
        return waveEnd;
    }

    public void setWaveEnd(Float waveEnd) {
        this.waveEnd = waveEnd;
    }
}
