package com.crledu.auto.material.microwaveIntegration.api.vo;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/11
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class MicrowaveIntegrationInfoVo {


    private Long id;
    //光源类型
    @ApiModelProperty(value = "光源类型")
    private Integer lightType;
    //入射角度
    @ApiModelProperty(value = "入射角度")
    private Float lightAngle;
    //工作方式
    @ApiModelProperty(value ="工作方式")
    private Integer workType;
    //起始频率
    @ApiModelProperty(value ="起始频率")
    private Float startFrequency;
    //结束频率
    @ApiModelProperty(value = "结束频率")
    private Float endFrequency;
    //介电常数
    @ApiModelProperty(value ="介电常数")
    private Float dielectric;
    //缝宽
    @ApiModelProperty(value ="缝宽")
    private Float g0;
    //金属条长度
    @ApiModelProperty(value = "金属条长度")
    private Float l0;
    //周期
    @ApiModelProperty(value = "周期")
    private Float p;
    //方形环外环边长
    @ApiModelProperty(value = "方形环外环边长")
    private Float l;
    //方形环之间间隔
    @ApiModelProperty(value = "方形环之间间隔")
    private Float g;
    //基底宽度
    @ApiModelProperty(value = "基底宽度")
    private Float s;
    //方形环宽度一层
    @ApiModelProperty(value = "方形环宽度一层")
    private Float s1;
    //方形环宽度二层
    @ApiModelProperty(value = "方形环宽度二层")
    private Float s2;
    //方形环宽度三层
    @ApiModelProperty(value = "方形环宽度三层")
    private Float s3;
    //基底材料方阻
    @ApiModelProperty(value = "基底材料方阻")
    private Float r;
    //方形环材料一层方阻
    @ApiModelProperty(value = "方形环材料一层方阻")
    private Float r1;
    //方形环材料二层方阻
    @ApiModelProperty(value = "方形环材料二层方阻")
    private Float r2;
    //方形环材料三层方阻
    @ApiModelProperty(value = "方形环材料三层方阻")
    private Float r3;
    @ApiModelProperty(value = "基底高度")
    //基底高度
    private Float h;
    //二层与一层间隔
    @ApiModelProperty(value = "二层与一层间隔")
    private Float h1;
    @ApiModelProperty(value = "二层与三层间隔")
    //二层与三层间隔
    private Float h2;
    //三层与基底层间隔
    @ApiModelProperty(value = "三层与基底层间隔")
    private Float h3;
    @ApiModelProperty(value = "数据来源")
    private Integer dataFrom;
    @ApiModelProperty(value = "导入历史id")
    private Long importId;
    @ApiModelProperty(value = "数据")
    private JSONObject Integration;
    /**
     * 透射相对带宽
     */
    @ApiModelProperty(value = "透射相对带宽")
    private Float tBandwidth;

    /**
     * 吸收相对带宽
     */
    @ApiModelProperty(value = "吸收相对带宽")
    private Float aBandwidth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Float getStartFrequency() {
        return startFrequency;
    }

    public void setStartFrequency(Float startFrequency) {
        this.startFrequency = startFrequency;
    }

    public Float getEndFrequency() {
        return endFrequency;
    }

    public void setEndFrequency(Float endFrequency) {
        this.endFrequency = endFrequency;
    }

    public Float getDielectric() {
        return dielectric;
    }

    public void setDielectric(Float dielectric) {
        this.dielectric = dielectric;
    }

    public Float getG0() {
        return g0;
    }

    public void setG0(Float g0) {
        this.g0 = g0;
    }

    public Float getL0() {
        return l0;
    }

    public void setL0(Float l0) {
        this.l0 = l0;
    }

    public Float getP() {
        return p;
    }

    public void setP(Float p) {
        this.p = p;
    }

    public Float getL() {
        return l;
    }

    public void setL(Float l) {
        this.l = l;
    }

    public Float getG() {
        return g;
    }

    public void setG(Float g) {
        this.g = g;
    }

    public Float getS() {
        return s;
    }

    public void setS(Float s) {
        this.s = s;
    }

    public Float getS1() {
        return s1;
    }

    public void setS1(Float s1) {
        this.s1 = s1;
    }

    public Float getS2() {
        return s2;
    }

    public void setS2(Float s2) {
        this.s2 = s2;
    }

    public Float getS3() {
        return s3;
    }

    public void setS3(Float s3) {
        this.s3 = s3;
    }

    public Float getR() {
        return r;
    }

    public void setR(Float r) {
        this.r = r;
    }

    public Float getR1() {
        return r1;
    }

    public void setR1(Float r1) {
        this.r1 = r1;
    }

    public Float getR2() {
        return r2;
    }

    public void setR2(Float r2) {
        this.r2 = r2;
    }

    public Float getR3() {
        return r3;
    }

    public void setR3(Float r3) {
        this.r3 = r3;
    }

    public Float getH() {
        return h;
    }

    public void setH(Float h) {
        this.h = h;
    }

    public Float getH1() {
        return h1;
    }

    public void setH1(Float h1) {
        this.h1 = h1;
    }

    public Float getH2() {
        return h2;
    }

    public void setH2(Float h2) {
        this.h2 = h2;
    }

    public Float getH3() {
        return h3;
    }

    public void setH3(Float h3) {
        this.h3 = h3;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public JSONObject getIntegration() {
        return Integration;
    }

    public void setIntegration(JSONObject integration) {
        Integration = integration;
    }

    public Float gettBandwidth() {
        return tBandwidth;
    }

    public void settBandwidth(Float tBandwidth) {
        this.tBandwidth = tBandwidth;
    }

    public Float getaBandwidth() {
        return aBandwidth;
    }

    public void setaBandwidth(Float aBandwidth) {
        this.aBandwidth = aBandwidth;
    }
}
