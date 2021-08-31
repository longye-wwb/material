package com.crledu.auto.material.microw.data.dto;

import com.crledu.auto.web.view.PageParamVO;
import com.crledu.auto.web.vo.number.FloatParamVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 微波宽带相位调控列表分页筛选
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/11 9:41
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("微波宽带相位调控筛选条件")
public class MicrowavePhaseSelectParamDto extends PageParamVO {

    @ApiModelProperty("金属厚度")
    private FloatParamVo thickness;

    @ApiModelProperty("工字型臂宽度角度")
    private FloatParamVo armr;

    @ApiModelProperty("工字型臂线宽")
    private FloatParamVo army;

    @ApiModelProperty("反射板距离系数")
    private FloatParamVo laylerx;

    @ApiModelProperty("周期系数")
    private FloatParamVo period;

    @ApiModelProperty("基板介电常数")
    private FloatParamVo permittivity;

    @ApiModelProperty("工字型矩形宽度（两侧）")
    private FloatParamVo rectx;

    @ApiModelProperty("工字型矩形宽度（中间）")
    private FloatParamVo rectx2;

    @ApiModelProperty("基板厚度")
    private FloatParamVo subh;

    @ApiModelProperty("工字型矩形线宽")
    private FloatParamVo recty;

    @ApiModelProperty("入射角")
    private FloatParamVo lightAngle;

    @ApiModelProperty("入射光源类型")
    private Integer lightType;

    @ApiModelProperty("工作方式")
    private Integer workingMode;

    @ApiModelProperty("数据来源")
    private Integer dataFrom;

    @ApiModelProperty("相对带宽")
    private FloatParamVo bandwidth;

    public MicrowavePhaseSelectParamDto() {
    }

    public FloatParamVo getThickness() {
        return thickness;
    }

    public void setThickness(FloatParamVo thickness) {
        this.thickness = thickness;
    }

    public FloatParamVo getArmr() {
        return armr;
    }

    public void setArmr(FloatParamVo armr) {
        this.armr = armr;
    }

    public FloatParamVo getArmy() {
        return army;
    }

    public void setArmy(FloatParamVo army) {
        this.army = army;
    }

    public FloatParamVo getLaylerx() {
        return laylerx;
    }

    public void setLaylerx(FloatParamVo laylerx) {
        this.laylerx = laylerx;
    }

    public FloatParamVo getPeriod() {
        return period;
    }

    public void setPeriod(FloatParamVo period) {
        this.period = period;
    }

    public FloatParamVo getPermittivity() {
        return permittivity;
    }

    public void setPermittivity(FloatParamVo permittivity) {
        this.permittivity = permittivity;
    }

    public FloatParamVo getRecty() {
        return recty;
    }

    public void setRecty(FloatParamVo recty) {
        this.recty = recty;
    }

    public FloatParamVo getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(FloatParamVo lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getWorkingMode() {
        return workingMode;
    }

    public void setWorkingMode(Integer workingMode) {
        this.workingMode = workingMode;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public FloatParamVo getRectx() {
        return rectx;
    }

    public void setRectx(FloatParamVo rectx) {
        this.rectx = rectx;
    }

    public FloatParamVo getRectx2() {
        return rectx2;
    }

    public void setRectx2(FloatParamVo rectx2) {
        this.rectx2 = rectx2;
    }

    public FloatParamVo getSubh() {
        return subh;
    }

    public void setSubh(FloatParamVo subh) {
        this.subh = subh;
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
