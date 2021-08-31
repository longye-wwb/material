package com.crledu.auto.material.microwave.api.vo;

import com.crledu.auto.web.view.PageParamVO;
import com.crledu.auto.web.vo.number.AbstractSelectNumberParamVo;
import com.crledu.auto.web.vo.number.FloatParamVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/10
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class MicrowaveSelectVo  extends PageParamVO {

    @ApiModelProperty(value = "结构材料")
    private Integer materialStructure;
    //总厚度
    @ApiModelProperty(value = "总厚度")
    private AbstractSelectNumberParamVo totalThickness;
    //填充材料
    @ApiModelProperty(value = "填充材料")
    private Integer filler;
    //材料层数，layer
    @ApiModelProperty(value ="材料层数")
    private Integer layer;
    //周期p
    @ApiModelProperty(value ="周期")
    private FloatParamVo p;
    private FloatParamVo g;
    private FloatParamVo s3;
    private FloatParamVo s1;
    private FloatParamVo s2;
    private FloatParamVo h1;
    private FloatParamVo h2;
    private FloatParamVo h3;
    private FloatParamVo rs1;
    private FloatParamVo rs2;
    private FloatParamVo rs3;
    @ApiModelProperty(value = "入射光类型")
    private Integer lightType;
    @ApiModelProperty(value = "入射光角度")
    private AbstractSelectNumberParamVo lightAngle;
    @ApiModelProperty(value = "开始频率")
    private AbstractSelectNumberParamVo startWave;
    @ApiModelProperty(value = "结束频率")
    private AbstractSelectNumberParamVo endWave;
    @ApiModelProperty(value = "工作方式")
    private Integer workType;
    @ApiModelProperty(value = "数据来源")
    private Integer dataFrom;

    @ApiModelProperty(value = "相对带宽")
    private FloatParamVo bandwidth;

    public Integer getMaterialStructure() {
        return materialStructure;
    }

    public void setMaterialStructure(Integer materialStructure) {
        this.materialStructure = materialStructure;
    }


    public Integer getFiller() {
        return filler;
    }

    public void setFiller(Integer filler) {
        this.filler = filler;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public FloatParamVo getP() {
        return p;
    }

    public void setP(FloatParamVo p) {
        this.p = p;
    }

    public FloatParamVo getG() {
        return g;
    }

    public void setG(FloatParamVo g) {
        this.g = g;
    }

    public FloatParamVo getS3() {
        return s3;
    }

    public void setS3(FloatParamVo s3) {
        this.s3 = s3;
    }

    public FloatParamVo getS1() {
        return s1;
    }

    public void setS1(FloatParamVo s1) {
        this.s1 = s1;
    }

    public FloatParamVo getS2() {
        return s2;
    }

    public void setS2(FloatParamVo s2) {
        this.s2 = s2;
    }

    public FloatParamVo getH1() {
        return h1;
    }

    public void setH1(FloatParamVo h1) {
        this.h1 = h1;
    }

    public FloatParamVo getH2() {
        return h2;
    }

    public void setH2(FloatParamVo h2) {
        this.h2 = h2;
    }

    public FloatParamVo getH3() {
        return h3;
    }

    public void setH3(FloatParamVo h3) {
        this.h3 = h3;
    }

    public FloatParamVo getRs1() {
        return rs1;
    }

    public void setRs1(FloatParamVo rs1) {
        this.rs1 = rs1;
    }

    public FloatParamVo getRs2() {
        return rs2;
    }

    public void setRs2(FloatParamVo rs2) {
        this.rs2 = rs2;
    }

    public FloatParamVo getRs3() {
        return rs3;
    }

    public void setRs3(FloatParamVo rs3) {
        this.rs3 = rs3;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public void setTotalThickness(AbstractSelectNumberParamVo totalThickness) {
        this.totalThickness = totalThickness;
    }

    public AbstractSelectNumberParamVo getTotalThickness() {
        return totalThickness;
    }

    public AbstractSelectNumberParamVo getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(AbstractSelectNumberParamVo lightAngle) {
        this.lightAngle = lightAngle;
    }

    public AbstractSelectNumberParamVo getStartWave() {
        return startWave;
    }

    public void setStartWave(AbstractSelectNumberParamVo startWave) {
        this.startWave = startWave;
    }

    public AbstractSelectNumberParamVo getEndWave() {
        return endWave;
    }

    public void setEndWave(AbstractSelectNumberParamVo endWave) {
        this.endWave = endWave;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public FloatParamVo getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(FloatParamVo bandwidth) {
        this.bandwidth = bandwidth;
    }
}
