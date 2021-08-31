package com.crledu.auto.material.microw.data.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 微波宽带相位调控列表属性
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/11 10:00
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("微波宽带相位调控数据")
public class MicrowavePhaseItemDto {

    @ApiModelProperty("主键")
    private Long id;
    /**
     * 金属厚度
     */
    @ApiModelProperty("金属厚度")
    private Float thickness;

    /**
     * 工字型臂宽度角度
     */
    @ApiModelProperty("工字型臂宽度角度")
    private Float armr;

    /**
     * 工字型臂线宽
     */
    @ApiModelProperty("工字型臂线宽")
    private Float army;

    /**
     * 反射板距离系数
     */
    @ApiModelProperty("反射板距离系数")
    private Float laylerx;

    /**
     * 周期系数
     */
    @ApiModelProperty("周期系数")
    private Float period;

    /**
     * 基板介电常数
     */
    @ApiModelProperty("基板介电常数")
    private Float permittivity;

    /**
     * 工字型矩形宽度（两侧）
     */
    @ApiModelProperty("工字型矩形宽度（两侧）")
    private Float rectx;

    /**
     * 工字型矩形宽度（中间）
     */
    @ApiModelProperty("工字型矩形宽度（中间）")
    private Float rectx2;

    /**
     * 基板厚度
     */
    @ApiModelProperty("基板厚度")
    private Float subh;

    /**
     * 工字型矩形线宽
     */
    @ApiModelProperty("工字型矩形线宽")
    private Float recty;

    /**
     * 入射角
     */
    @ApiModelProperty("入射角")
    private Float lightAngle;

    @ApiModelProperty("入射光源类型")
    private Integer lightType;

    /**
     * 工作方式
     */
    @ApiModelProperty("工作方式")
    private Integer workingMode;

    /**
     * 导入历史
     */
    @ApiModelProperty("导入历史")
    private Long importId;

    /**
     * 数据来源
     */
    @ApiModelProperty("数据来源")
    private Integer dataFrom;

    @ApiModelProperty("相对带宽")
    private Float bandwidth;

    public MicrowavePhaseItemDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getThickness() {
        return thickness;
    }

    public void setThickness(Float thickness) {
        this.thickness = thickness;
    }

    public Float getArmr() {
        return armr;
    }

    public void setArmr(Float armr) {
        this.armr = armr;
    }

    public Float getArmy() {
        return army;
    }

    public void setArmy(Float army) {
        this.army = army;
    }

    public Float getLaylerx() {
        return laylerx;
    }

    public void setLaylerx(Float laylerx) {
        this.laylerx = laylerx;
    }

    public Float getPeriod() {
        return period;
    }

    public void setPeriod(Float period) {
        this.period = period;
    }

    public Float getPermittivity() {
        return permittivity;
    }

    public void setPermittivity(Float permittivity) {
        this.permittivity = permittivity;
    }

    public Float getRecty() {
        return recty;
    }

    public void setRecty(Float recty) {
        this.recty = recty;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getWorkingMode() {
        return workingMode;
    }

    public void setWorkingMode(Integer workingMode) {
        this.workingMode = workingMode;
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

    public Float getRectx() {
        return rectx;
    }

    public void setRectx(Float rectx) {
        this.rectx = rectx;
    }

    public Float getRectx2() {
        return rectx2;
    }

    public void setRectx2(Float rectx2) {
        this.rectx2 = rectx2;
    }

    public Float getSubh() {
        return subh;
    }

    public void setSubh(Float subh) {
        this.subh = subh;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public Float getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Float bandwidth) {
        this.bandwidth = bandwidth;
    }
}
