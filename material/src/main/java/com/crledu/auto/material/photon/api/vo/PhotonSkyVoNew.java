package com.crledu.auto.material.photon.api.vo;

import com.alibaba.excel.annotation.ExcelProperty;
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
public class PhotonSkyVoNew {

    private Long id;

    @ApiModelProperty(value = "纳米天线结构类型")
    @ExcelProperty(value = "天线结构")
    private String topType;

    @ApiModelProperty(value = "纳米天线材料")
    @ExcelProperty(value = "天线介电常数")
    private Double topConstant;

    @ApiModelProperty(value = "基底结构类型")
    @ExcelProperty(value = "基底结构")
    private String downType;

    @ApiModelProperty(value = "基底材料")
    @ExcelProperty(value = "基底介电常数")
    private Double downConstant;

    @ApiModelProperty(value = "数据来源")
    @ExcelProperty(value = "数据来源")
    private String source;

    @ApiModelProperty(value = "入射光源类型")
    @ExcelProperty(value = "入射光源")
    private String lightType;

    @ApiModelProperty(value = "入射角")
    @ExcelProperty(value = "入射角")
    private Double lightAngle;

    @ApiModelProperty(value ="工作方式")
    @ExcelProperty(value = "工作方式")
    private String workType;

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

    @ApiModelProperty(value = "起始波长")
    @ExcelProperty(value = "起始波长")
    private Double start;

    @ApiModelProperty(value = "结束波长")
    @ExcelProperty(value = "结束波长")
    private Double end;

    @ApiModelProperty(value = "附件")
    private String file;

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLightType() {
        return lightType;
    }

    public void setLightType(String lightType) {
        this.lightType = lightType;
    }

    public Double getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Double lightAngle) {
        this.lightAngle = lightAngle;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
