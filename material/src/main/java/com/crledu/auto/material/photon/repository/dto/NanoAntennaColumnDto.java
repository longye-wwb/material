package com.crledu.auto.material.photon.repository.dto;

import com.crledu.auto.material.photon.biz.domain.NanoAntennaLayerDomain;

import java.util.List;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/11/26
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class NanoAntennaColumnDto {

    //纳米天线结构类型
    private Integer topType;
    //纳米天线材料
    private Double topConstant;
    //基底结构类型
    private Integer downType;
    //基底材料
    private Double downConstant;
    //入射光源类型
    private Integer lightType;
    //数据来源
    private Integer source;
    //工作方式
    private Integer workType;
    //天线长轴
    private Double x;
    //天线短轴
    private Double y;
    //面内偏转角度
    private  Double angle;
    //基底高度
    private Double h;
    //基底边长
    private Double p;
    //天线高度
    private Double minH;
    //开始波长
    private Double startL;
    //结束波长
    private Double endL;
    private List<NanoAntennaLayerDto> layerDtos;
    //起始频率
    private Double startFrequncy;
    //结束频率
    private Double endFrequncy;

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

    public Double getMinH() {
        return minH;
    }

    public void setMinH(Double minH) {
        this.minH = minH;
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

    public List<NanoAntennaLayerDto> getLayerDtos() {
        return layerDtos;
    }

    public void setLayerDtos(List<NanoAntennaLayerDto> layerDtos) {
        this.layerDtos = layerDtos;
    }

    public Double getStartFrequncy() {
        return startFrequncy;
    }

    public void setStartFrequncy(Double startFrequncy) {
        this.startFrequncy = startFrequncy;
    }

    public Double getEndFrequncy() {
        return endFrequncy;
    }

    public void setEndFrequncy(Double endFrequncy) {
        this.endFrequncy = endFrequncy;
    }
}
