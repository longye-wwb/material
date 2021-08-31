package com.crledu.auto.material.grating.api.vo;

import com.crledu.auto.web.view.PageParamVO;
import com.crledu.auto.web.vo.number.FloatParamVo;
import com.crledu.auto.web.vo.StringParamVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 红外光栅材料筛选
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/4 17:18
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("红外窄带传感材料筛选")
public class InfraredGratingSelectParamVo extends PageParamVO {

    @ApiModelProperty("材料")
    private StringParamVo material;

    @ApiModelProperty("微结构高")
    private FloatParamVo height;

    @ApiModelProperty("微结构宽")
    private FloatParamVo width;

    @ApiModelProperty("边缘间距")
    private FloatParamVo space;

    @ApiModelProperty("入射角")
    private FloatParamVo lightAngle;

    @ApiModelProperty("入射光源类型")
    private Integer lightType;

    @ApiModelProperty("相对带宽")
    private FloatParamVo bandwidth;

    public InfraredGratingSelectParamVo() {
    }

    public StringParamVo getMaterial() {
        return material;
    }

    public void setMaterial(StringParamVo material) {
        this.material = material;
    }

    public FloatParamVo getHeight() {
        return height;
    }

    public void setHeight(FloatParamVo height) {
        this.height = height;
    }

    public FloatParamVo getWidth() {
        return width;
    }

    public void setWidth(FloatParamVo width) {
        this.width = width;
    }

    public FloatParamVo getSpace() {
        return space;
    }

    public void setSpace(FloatParamVo space) {
        this.space = space;
    }

    public FloatParamVo getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(FloatParamVo lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public FloatParamVo getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(FloatParamVo bandwidth) {
        this.bandwidth = bandwidth;
    }
}
