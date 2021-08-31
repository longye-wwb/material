package com.crledu.auto.material.photon.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "at_sky_new")
public class PhotonSkyNew {

    private Long id;

    @ApiModelProperty(value = "纳米天线结构类型")
    private Integer topType;

    @ApiModelProperty(value = "纳米天线材料")
    private Double topConstant;

    @ApiModelProperty(value = "基底结构类型")
    private Integer downType;

    @ApiModelProperty(value = "基底材料")
    private Double downConstant;

    @ApiModelProperty(value = "数据来源")
    private Integer source;

    @ApiModelProperty(value = "入射光源类型")
    private Integer lightType;

    @ApiModelProperty(value = "入射角")
    private Double lightAngle;

    @ApiModelProperty(value ="工作方式")
    private Integer workType;

    @ApiModelProperty(value = "基底高度")
    private Double h;

    @ApiModelProperty(value = "基底边长")
    private Double p;

    @ApiModelProperty(value = "天线高度")
    private Double minH;

    @ApiModelProperty(value ="天线半径")
    private Double r;
    @ApiModelProperty(value = "天线长轴")
    private Double x;
    @ApiModelProperty(value = "天线短轴")
    private Double y;
    @ApiModelProperty(value = "线内偏转角度")
    private Double angle;

    private String file;

    private Double startL;

    private Double endL;

    //数据文件地址
    private String fileUrl;

    private Long importId;

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public Double getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Double lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Double getStartL() {
        return startL;
    }

    public void setStartL(Double startL) {
        this.startL = startL;
    }

    public Double getEndL() {
        return endL;
    }

    public void setEndL(Double endL) {
        this.endL = endL;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
