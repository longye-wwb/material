package com.crledu.auto.material.microwave.api.vo;

import com.alibaba.fastjson.JSONObject;
import com.crledu.auto.material.microwave.biz.dto.AbsorptionRateDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

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
public class MicrowaveInfoVo {

    private Long id;
    //结构材料
    @ApiModelProperty(value = "结构材料")
    private Integer materialStructure;
    //总厚度
    @ApiModelProperty(value = "总厚度")
    private Float totalThickness;
    //填充材料
    @ApiModelProperty(value = "填充材料")
    private Integer filler;
    //材料层数，layer
    @ApiModelProperty(value ="材料层数")
    private Integer layer;
    //周期p
    @ApiModelProperty(value ="周期")
    private Float p;
    private Float g;
    private Float s3;
    private Float s1;
    private Float s2;
    private Float h1;
    private Float h2;
    private Float h3;
    private Float rs1;
    private Float rs2;
    private Float rs3;
    @ApiModelProperty(value = "入射光类型")
    private Integer lightType;
    @ApiModelProperty(value = "入射光角度")
    private Float lightAngle;
    @ApiModelProperty(value = "开始频率")
    private Float startWave;
    @ApiModelProperty(value = "结束频率")
    private Float endWave;
    @ApiModelProperty(value = "工作方式")
    private Integer workType;
    @ApiModelProperty(value = "数据来源")
    private Integer dataFrom;
    @ApiModelProperty(value = "数据导入历史")
    private Long importId;
    @ApiModelProperty(value = "相对带宽")
    private Float bandwidth;

    private JSONObject absorptionRateDtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaterialStructure() {
        return materialStructure;
    }

    public void setMaterialStructure(Integer materialStructure) {
        this.materialStructure = materialStructure;
    }

    public Float getTotalThickness() {
        return totalThickness;
    }

    public void setTotalThickness(Float totalThickness) {
        this.totalThickness = totalThickness;
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

    public Float getP() {
        return p;
    }

    public void setP(Float p) {
        this.p = p;
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

    public Float getStartWave() {
        return startWave;
    }

    public void setStartWave(Float startWave) {
        this.startWave = startWave;
    }

    public Float getEndWave() {
        return endWave;
    }

    public void setEndWave(Float endWave) {
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

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public JSONObject getAbsorptionRateDtos() {
        return absorptionRateDtos;
    }

    public void setAbsorptionRateDtos(JSONObject absorptionRateDtos) {
        this.absorptionRateDtos = absorptionRateDtos;
    }

    public Float getG() {
        return g;
    }

    public void setG(Float g) {
        this.g = g;
    }

    public Float getS3() {
        return s3;
    }

    public void setS3(Float s3) {
        this.s3 = s3;
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

    public Float getRs1() {
        return rs1;
    }

    public void setRs1(Float rs1) {
        this.rs1 = rs1;
    }

    public Float getRs2() {
        return rs2;
    }

    public void setRs2(Float rs2) {
        this.rs2 = rs2;
    }

    public Float getRs3() {
        return rs3;
    }

    public void setRs3(Float rs3) {
        this.rs3 = rs3;
    }

    public Float getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Float bandwidth) {
        this.bandwidth = bandwidth;
    }
}
