package com.crledu.auto.material.microwaveIntegration.api.vo;

import com.crledu.auto.web.view.PageParamVO;
import com.crledu.auto.web.vo.number.AbstractSelectNumberParamVo;
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
public class MicrowaveIntegrationSelectVo  extends PageParamVO {

    //光源类型
    @ApiModelProperty(value = "光源类型")
    private Integer lightType;
    //入射角度
    @ApiModelProperty(value = "入射角度")
    private AbstractSelectNumberParamVo lightAngle;
    //工作方式
    @ApiModelProperty(value ="工作方式")
    private Integer workType;
    //起始频率
    @ApiModelProperty(value = "起始频率")
    private AbstractSelectNumberParamVo startFrequency;
    //结束频率
    @ApiModelProperty(value = "结束频率")
    private AbstractSelectNumberParamVo endFrequency;
    //介电常数
    @ApiModelProperty(value = "介电常数")
    private AbstractSelectNumberParamVo dielectric;
    //缝宽
    @ApiModelProperty(value = "g0")
    private AbstractSelectNumberParamVo g0;
    //金属条长度
    @ApiModelProperty(value ="l0")
    private AbstractSelectNumberParamVo l0;
    //周期
    @ApiModelProperty(value = "p")
    private AbstractSelectNumberParamVo p;
    //方形环外环边长
    @ApiModelProperty(value = "l")
    private AbstractSelectNumberParamVo l;
    //方形环之间间隔
    @ApiModelProperty(value = "g")
    private AbstractSelectNumberParamVo g;
    //基底宽度
    @ApiModelProperty(value = "s")
    private AbstractSelectNumberParamVo s;
    //方形环宽度一层
    @ApiModelProperty(value = "s1")
    private AbstractSelectNumberParamVo s1;
    //方形环宽度二层
    @ApiModelProperty(value = "s2")
    private AbstractSelectNumberParamVo s2;
    //方形环宽度三层
    @ApiModelProperty(value = "s3")
    private AbstractSelectNumberParamVo s3;
    //基底材料方阻
    @ApiModelProperty(value = "r")
    private AbstractSelectNumberParamVo r;
    //方形环材料一层方阻
    @ApiModelProperty(value = "r1")
    private AbstractSelectNumberParamVo r1;
    //方形环材料二层方阻
    @ApiModelProperty(value = "r2")
    private AbstractSelectNumberParamVo r2;
    //方形环材料三层方阻
    @ApiModelProperty(value = "r3")
    private AbstractSelectNumberParamVo r3;
    //基底高度
    @ApiModelProperty(value = "h")
    private AbstractSelectNumberParamVo h;
    //二层与一层间隔
    @ApiModelProperty(value = "h1")
    private AbstractSelectNumberParamVo h1;
    //二层与三层间隔
    @ApiModelProperty(value = "h2")
    private AbstractSelectNumberParamVo h2;
    //三层与基底层间隔
    @ApiModelProperty(value = "h3")
    private AbstractSelectNumberParamVo h3;
    @ApiModelProperty(value = "数据来源")
    private Integer dataFrom;

    @ApiModelProperty("透射相对带宽")
    private AbstractSelectNumberParamVo tBandwidth;

    @ApiModelProperty("吸收相对带宽")
    private AbstractSelectNumberParamVo aBandwidth;

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public AbstractSelectNumberParamVo getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(AbstractSelectNumberParamVo lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public AbstractSelectNumberParamVo getStartFrequency() {
        return startFrequency;
    }

    public void setStartFrequency(AbstractSelectNumberParamVo startFrequency) {
        this.startFrequency = startFrequency;
    }

    public AbstractSelectNumberParamVo getEndFrequency() {
        return endFrequency;
    }

    public void setEndFrequency(AbstractSelectNumberParamVo endFrequency) {
        this.endFrequency = endFrequency;
    }

    public AbstractSelectNumberParamVo getDielectric() {
        return dielectric;
    }

    public void setDielectric(AbstractSelectNumberParamVo dielectric) {
        this.dielectric = dielectric;
    }

    public AbstractSelectNumberParamVo getG0() {
        return g0;
    }

    public void setG0(AbstractSelectNumberParamVo g0) {
        this.g0 = g0;
    }

    public AbstractSelectNumberParamVo getL0() {
        return l0;
    }

    public void setL0(AbstractSelectNumberParamVo l0) {
        this.l0 = l0;
    }

    public AbstractSelectNumberParamVo getP() {
        return p;
    }

    public void setP(AbstractSelectNumberParamVo p) {
        this.p = p;
    }

    public AbstractSelectNumberParamVo getL() {
        return l;
    }

    public void setL(AbstractSelectNumberParamVo l) {
        this.l = l;
    }

    public AbstractSelectNumberParamVo getG() {
        return g;
    }

    public void setG(AbstractSelectNumberParamVo g) {
        this.g = g;
    }

    public AbstractSelectNumberParamVo getS() {
        return s;
    }

    public void setS(AbstractSelectNumberParamVo s) {
        this.s = s;
    }

    public AbstractSelectNumberParamVo getS1() {
        return s1;
    }

    public void setS1(AbstractSelectNumberParamVo s1) {
        this.s1 = s1;
    }

    public AbstractSelectNumberParamVo getS2() {
        return s2;
    }

    public void setS2(AbstractSelectNumberParamVo s2) {
        this.s2 = s2;
    }

    public AbstractSelectNumberParamVo getS3() {
        return s3;
    }

    public void setS3(AbstractSelectNumberParamVo s3) {
        this.s3 = s3;
    }

    public AbstractSelectNumberParamVo getR() {
        return r;
    }

    public void setR(AbstractSelectNumberParamVo r) {
        this.r = r;
    }

    public AbstractSelectNumberParamVo getR1() {
        return r1;
    }

    public void setR1(AbstractSelectNumberParamVo r1) {
        this.r1 = r1;
    }

    public AbstractSelectNumberParamVo getR2() {
        return r2;
    }

    public void setR2(AbstractSelectNumberParamVo r2) {
        this.r2 = r2;
    }

    public AbstractSelectNumberParamVo getR3() {
        return r3;
    }

    public void setR3(AbstractSelectNumberParamVo r3) {
        this.r3 = r3;
    }

    public AbstractSelectNumberParamVo getH() {
        return h;
    }

    public void setH(AbstractSelectNumberParamVo h) {
        this.h = h;
    }

    public AbstractSelectNumberParamVo getH1() {
        return h1;
    }

    public void setH1(AbstractSelectNumberParamVo h1) {
        this.h1 = h1;
    }

    public AbstractSelectNumberParamVo getH2() {
        return h2;
    }

    public void setH2(AbstractSelectNumberParamVo h2) {
        this.h2 = h2;
    }

    public AbstractSelectNumberParamVo getH3() {
        return h3;
    }

    public void setH3(AbstractSelectNumberParamVo h3) {
        this.h3 = h3;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public AbstractSelectNumberParamVo gettBandwidth() {
        return tBandwidth;
    }

    public void settBandwidth(AbstractSelectNumberParamVo tBandwidth) {
        this.tBandwidth = tBandwidth;
    }

    public AbstractSelectNumberParamVo getaBandwidth() {
        return aBandwidth;
    }

    public void setaBandwidth(AbstractSelectNumberParamVo aBandwidth) {
        this.aBandwidth = aBandwidth;
    }
}
