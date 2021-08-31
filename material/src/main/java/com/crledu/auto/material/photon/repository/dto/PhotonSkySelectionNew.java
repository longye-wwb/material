package com.crledu.auto.material.photon.repository.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/9/16
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class PhotonSkySelectionNew {

    @ApiModelProperty(value = "纳米天线结构类型")
    private Integer topType;
    @ApiModelProperty(value = "纳米天线材料")
    private Double topConstant;
    @ApiModelProperty(value = "基底结构类型")
    private Integer downType;
    @ApiModelProperty(value = "基底材料")
    private Double downConstant;
    @ApiModelProperty(value = "入射光源类型")
    private Integer lightType;
    @ApiModelProperty(value = "入射角起始")
    private Double lightAngleStart;
    @ApiModelProperty(value = "入射角结束")
    private Double lightAngleEnd;
    @ApiModelProperty(value = "数据来源")
    private Integer source;
    @ApiModelProperty(value ="工作方式")
    private Integer workType;
    @ApiModelProperty(value = "天线高度起始")
    private Double minHStart;
    @ApiModelProperty(value = "天线高度结束")
    private Double minHEnd;
    @ApiModelProperty(value = "天线半径起始")
    private Double rStart;
    @ApiModelProperty(value = "天线半径结束")
    private Double rEnd;
    @ApiModelProperty(value = "天线长轴起始")
    private Double xStart;
    @ApiModelProperty(value = "天线长轴结束")
    private Double xEnd;
    @ApiModelProperty(value = "天线短轴起始")
    private Double yStart;
    @ApiModelProperty(value = "天线短轴结束")
    private Double yEnd;
    @ApiModelProperty(value = "面内旋转角度起始")
    private Double angleStart;
    @ApiModelProperty(value = "面内旋转角度结束")
    private Double angleEnd;
    @ApiModelProperty(value = "基底高度起始")
    private Double hStart;
    @ApiModelProperty(value = "基底高度结束")
    private Double hEnd;
    @ApiModelProperty(value = "基底边长起始")
    private Double pStart;
    @ApiModelProperty(value = "基底边长结束")
    private Double pEnd;
    private Integer pageNum;
    private Integer pageSize;
    private Long importId;

    public Integer getTopType() {
        return topType;
    }

    public void setTopType(Integer topType) {
        this.topType = topType;
    }

    public Double getTopConstant() {
        return topConstant;
    }

    public void setTopConstant(Double topConstant) {
        this.topConstant = topConstant;
    }

    public Integer getDownType() {
        return downType;
    }

    public void setDownType(Integer downType) {
        this.downType = downType;
    }

    public Double getDownConstant() {
        return downConstant;
    }

    public void setDownConstant(Double downConstant) {
        this.downConstant = downConstant;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public Double getLightAngleStart() {
        return lightAngleStart;
    }

    public void setLightAngleStart(Double lightAngleStart) {
        this.lightAngleStart = lightAngleStart;
    }

    public Double getLightAngleEnd() {
        return lightAngleEnd;
    }

    public void setLightAngleEnd(Double lightAngleEnd) {
        this.lightAngleEnd = lightAngleEnd;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public Double getMinHStart() {
        return minHStart;
    }

    public void setMinHStart(Double minHStart) {
        this.minHStart = minHStart;
    }

    public Double getMinHEnd() {
        return minHEnd;
    }

    public void setMinHEnd(Double minHEnd) {
        this.minHEnd = minHEnd;
    }

    public Double getrStart() {
        return rStart;
    }

    public void setrStart(Double rStart) {
        this.rStart = rStart;
    }

    public Double getrEnd() {
        return rEnd;
    }

    public void setrEnd(Double rEnd) {
        this.rEnd = rEnd;
    }

    public Double getxStart() {
        return xStart;
    }

    public void setxStart(Double xStart) {
        this.xStart = xStart;
    }

    public Double getxEnd() {
        return xEnd;
    }

    public void setxEnd(Double xEnd) {
        this.xEnd = xEnd;
    }

    public Double getyStart() {
        return yStart;
    }

    public void setyStart(Double yStart) {
        this.yStart = yStart;
    }

    public Double getyEnd() {
        return yEnd;
    }

    public void setyEnd(Double yEnd) {
        this.yEnd = yEnd;
    }

    public Double getAngleStart() {
        return angleStart;
    }

    public void setAngleStart(Double angleStart) {
        this.angleStart = angleStart;
    }

    public Double getAngleEnd() {
        return angleEnd;
    }

    public void setAngleEnd(Double angleEnd) {
        this.angleEnd = angleEnd;
    }

    public Double gethStart() {
        return hStart;
    }

    public void sethStart(Double hStart) {
        this.hStart = hStart;
    }

    public Double gethEnd() {
        return hEnd;
    }

    public void sethEnd(Double hEnd) {
        this.hEnd = hEnd;
    }

    public Double getpStart() {
        return pStart;
    }

    public void setpStart(Double pStart) {
        this.pStart = pStart;
    }

    public Double getpEnd() {
        return pEnd;
    }

    public void setpEnd(Double pEnd) {
        this.pEnd = pEnd;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }
}
