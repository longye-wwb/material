package com.crledu.auto.material.second.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 衍射组件
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/12 21:05
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("导入衍射数据")
public class DiffractionCreateVo {

    /**
     * 入射波长
     */
    @ApiModelProperty("入射波长")
    private float inLine;

    /**
     * 材料周期
     */
    @ApiModelProperty("材料周期")
    private float period;

    /**
     * 材料折射率
     */
    @ApiModelProperty("材料折射率")
    private float refractive;

    /**
     * 基底折射率
     */
    @ApiModelProperty("基底折射率")
    private float BaseRefractive;

    /**
     * 衍射角
     */
    @ApiModelProperty("衍射角")
    private float angle;

    /**
     * 衍射阶数
     */
    @ApiModelProperty("衍射阶数")
    private int order;

    @ApiModelProperty(value = "数据来源")
    private Integer dataFrom;

    public DiffractionCreateVo() {
    }

    public float getInLine() {
        return inLine;
    }

    public void setInLine(float inLine) {
        this.inLine = inLine;
    }

    public float getPeriod() {
        return period;
    }

    public void setPeriod(float period) {
        this.period = period;
    }

    public float getRefractive() {
        return refractive;
    }

    public void setRefractive(float refractive) {
        this.refractive = refractive;
    }

    public float getBaseRefractive() {
        return BaseRefractive;
    }

    public void setBaseRefractive(float baseRefractive) {
        BaseRefractive = baseRefractive;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }
}
