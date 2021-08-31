package com.crledu.auto.material.photon.repository.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/9/3
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class PhotonSkySelection {

    @ApiModelProperty(value = "纳米天线结构类型",required = true)
    private String topType;
    @ApiModelProperty(value = "纳米天线材料")
    private Double topConstant;
    @ApiModelProperty(value = "基底结构类型")
    private String downType;
    @ApiModelProperty(value = "基底材料")
    private Double downConstant;
    @ApiModelProperty(value = "入射光源类型")
    private String lightType;
    @ApiModelProperty(value = "入射角起始")
    private Double lightAngleStart;
    @ApiModelProperty(value = "入射角结束")
    private Double lightAngleEnd;
    @ApiModelProperty(value = "数据来源")
    private String source;
    @ApiModelProperty(value ="工作方式")
    private String workType;
    @ApiModelProperty(value = "起始波段")
    private Double start;
    @ApiModelProperty(value = "结束波段")
    private Double end;
    @ApiModelProperty(value = "天线高度")
    private Double minH;
    @ApiModelProperty(value = "天线半径")
    private Double r;
    @ApiModelProperty(value = "天线长轴")
    private Double x;
    @ApiModelProperty(value = "天线短轴")
    private Double y;
    @ApiModelProperty(value = "面内旋转角度")
    private Double angle;
    @ApiModelProperty(value = "基底高度")
    private Double h;

    @ApiModelProperty(value = "基底边长")
    private Double p;

    private Integer pageNum;

    private Integer pageSize;

    public String getTopType() {
        return topType;
    }

    public void setTopType(String topType) {
        this.topType = topType;
    }

    public Double getTopConstant() {
        return topConstant;
    }

    public void setTopConstant(Double topConstant) {
        this.topConstant = topConstant;
    }

    public String getDownType() {
        return downType;
    }

    public void setDownType(String downType) {
        this.downType = downType;
    }

    public Double getDownConstant() {
        return downConstant;
    }

    public void setDownConstant(Double downConstant) {
        this.downConstant = downConstant;
    }

    public String getLightType() {
        return lightType;
    }

    public void setLightType(String lightType) {
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

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public Double getStart() {
        return start;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getEnd() {
        return end;
    }

    public void setEnd(Double end) {
        this.end = end;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Double getMinH() {
        return minH;
    }

    public void setMinH(Double minH) {
        this.minH = minH;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public Double getH() {
        return h;
    }

    public void setH(Double h) {
        this.h = h;
    }

    public Double getP() {
        return p;
    }

    public void setP(Double p) {
        this.p = p;
    }
}
