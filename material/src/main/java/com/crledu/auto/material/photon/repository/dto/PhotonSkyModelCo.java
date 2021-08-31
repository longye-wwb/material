package com.crledu.auto.material.photon.repository.dto;

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
 * @Date: 2020/9/3
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class PhotonSkyModelCo {

    @ExcelProperty(value = "纳米天线结构类型")
    private String topType;

    @ExcelProperty(value = "纳米天线材料")
    private Double topConstant;

    @ExcelProperty(value = "天线长轴")
    private Double x;

    @ExcelProperty(value = "天线短轴")
    private Double y;

    @ExcelProperty(value = "天线高度")
    private Double minH;

    @ExcelProperty(value = "面内旋转角度")
    private  Double angle;

    @ExcelProperty(value = "基底结构类型")
    private String downType;

    @ExcelProperty(value = "基底材料")
    private Double downConstant;


    @ExcelProperty(value = "基座厚度")
    private Double h;

    @ExcelProperty(value = "基座边长")
    private Double p;

    @ExcelProperty(value = "数据来源")
    private String source;

    @ExcelProperty(value = "入射光源类型")
    private String lightType;

    @ExcelProperty(value = "入射角")
    private Double lightAngle;

    @ExcelProperty(value = "起始波段")
    private Double start;

    @ExcelProperty(value = "结束波段")
    private Double end;

    @ExcelProperty(value ="工作方式")
    private String workType;

    @ExcelProperty(value = "相位分布")
    private Double amplitude;

    @ExcelProperty(value = "振幅分布")
    private Double phase;


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

    public Double getMinH() {
        return minH;
    }

    public void setMinH(Double minH) {
        this.minH = minH;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
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

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public Double getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(Double amplitude) {
        this.amplitude = amplitude;
    }

    public Double getPhase() {
        return phase;
    }

    public void setPhase(Double phase) {
        this.phase = phase;
    }
}
