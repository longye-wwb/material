package com.crledu.auto.material.breath.api.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/8
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class BreadthListVo {

    private Long id;

    @ApiModelProperty(value = "数据来源")
    private Integer dataFrom;
    //入射角
    @ApiModelProperty(value = "入射角")
    private Float lightAngle;
    //类型
    @ApiModelProperty(value = "类型，微波窄带吸收")
    private Integer type;
    //结构材料
    @ApiModelProperty(value ="结构材料")
    private String structureMaterial;
    //结构厚度 d
    @ApiModelProperty(value ="结构厚度")
    private Float structureThickness;

    //基底材料
    @ApiModelProperty(value = "基底材料")
    private String baseMaterial;
    //基底厚度 t1
    @ApiModelProperty(value ="基底厚度")
    private Float baseThickness;
    //介质材料
    @ApiModelProperty(value = "介质材料")
    private String mediumMaterial;
    //介电常数
    @ApiModelProperty(value = "介电常数")
    private Float dielectric;
    //损耗正切
    @ApiModelProperty(value = "损耗正切")
    private Float loss;
    //结构周期
    @ApiModelProperty(value = "结构周期")
    private Float period;
    @ApiModelProperty(value ="结构外环边长")
    private Float length;
    //结构宽度 w
    @ApiModelProperty(value = "结构宽度")
    private Float width;
    //介质厚度 t2
    @ApiModelProperty(value = "介质厚度")
    private Float mediumThickness;
    //波段
    @ApiModelProperty(value ="功做波段")
    private String workingBand;
    @ApiModelProperty(value = "数据导入历史")
    private Long importId;

    @ApiModelProperty("光源类型")
    private Integer lightType;

    @ApiModelProperty("工作方式")
    private Integer workMode;

    @ApiModelProperty("相对带宽")
    private Float bandwidth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStructureMaterial() {
        return structureMaterial;
    }

    public void setStructureMaterial(String structureMaterial) {
        this.structureMaterial = structureMaterial;
    }

    public Float getStructureThickness() {
        return structureThickness;
    }

    public void setStructureThickness(Float structureThickness) {
        this.structureThickness = structureThickness;
    }

    public String getBaseMaterial() {
        return baseMaterial;
    }

    public void setBaseMaterial(String baseMaterial) {
        this.baseMaterial = baseMaterial;
    }

    public Float getBaseThickness() {
        return baseThickness;
    }

    public void setBaseThickness(Float baseThickness) {
        this.baseThickness = baseThickness;
    }

    public String getMediumMaterial() {
        return mediumMaterial;
    }

    public void setMediumMaterial(String mediumMaterial) {
        this.mediumMaterial = mediumMaterial;
    }

    public Float getDielectric() {
        return dielectric;
    }

    public void setDielectric(Float dielectric) {
        this.dielectric = dielectric;
    }

    public Float getLoss() {
        return loss;
    }

    public void setLoss(Float loss) {
        this.loss = loss;
    }

    public Float getPeriod() {
        return period;
    }

    public void setPeriod(Float period) {
        this.period = period;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getMediumThickness() {
        return mediumThickness;
    }

    public void setMediumThickness(Float mediumThickness) {
        this.mediumThickness = mediumThickness;
    }

    public String getWorkingBand() {
        return workingBand;
    }

    public void setWorkingBand(String workingBand) {
        this.workingBand = workingBand;
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public Integer getWorkMode() {
        return workMode;
    }

    public void setWorkMode(Integer workMode) {
        this.workMode = workMode;
    }

    public Float getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Float bandwidth) {
        this.bandwidth = bandwidth;
    }
}
