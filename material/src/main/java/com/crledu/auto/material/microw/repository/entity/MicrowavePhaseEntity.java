package com.crledu.auto.material.microw.repository.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 ************************************************************
 * @Description: 微波宽带相位调控数据实体
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 17:32
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@TableName("at_micro_phase")
public class MicrowavePhaseEntity {

    @TableId
    private Long id;
    /**
     * 金属厚度
     */
    private Float thickness;

    /**
     * 工字型臂宽度角度
     */
    private Float armr;

    /**
     * 工字型臂线宽
     */
    private Float army;

    /**
     * 反射板距离系数
     */
    private Float laylerx;

    /**
     * 周期系数
     */
    private Float period;

    /**
     * 基板介电常数
     */
    private Float permittivity;

    /**
     * 工字型矩形宽度（两侧）
     */
    private Float rectx;

    /**
     * 工字型矩形宽度（中间）
     */
    private Float rectx2;

    /**
     * 基板厚度
     */
    private Float subh;

    /**
     * 工字型矩形线宽
     */
    private Float recty;

    /**
     * 入射角
     */
    private Float lightAngle;

    private Integer lightType;

    /**
     * 工作方式
     */
    private Integer workingMode;

    /**
     * 数据文件地址
     */
    private String data;

    private Long importId;

    private Integer dataFrom;

    /**
     * 相对带宽
     */
    private Float bandwidth;

    public MicrowavePhaseEntity() {
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

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public Integer getWorkingMode() {
        return workingMode;
    }

    public void setWorkingMode(Integer workingMode) {
        this.workingMode = workingMode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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

    public Float getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Float bandwidth) {
        this.bandwidth = bandwidth;
    }
}
