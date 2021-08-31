package com.crledu.auto.material.photon.biz.domain;

import com.crledu.auto.material.photon.repository.util.DoubleUtil;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * ***********************************************************
 *
 * @Description: 柱形。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/11/24
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class NanoAntennaColumnDomain {

    private Long id;
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

    private List<NanoAntennaLayerDomain> layerDomains;
    //虚部数据


    //起始频率
    private Double startFrequncy;
    //结束频率
    private Double endFrequncy;

    public Integer getTopType() {
        return topType;
    }

    public Double getTopConstant() {
        return topConstant;
    }

    public Integer getDownType() {
        return downType;
    }

    public Double getDownConstant() {
        return downConstant;
    }

    public Integer getLightType() {
        return lightType;
    }

    public Integer getSource() {
        return source;
    }

    public Integer getWorkType() {
        return workType;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getAngle() {
        return angle;
    }

    public Double getH() {
        return h;
    }

    public Double getP() {
        return p;
    }

    public Double getMinH() {
        return minH;
    }

    public Double getStartL() {
        return startL;
    }

    public Double getEndL() {
        return endL;
    }

    public List<NanoAntennaLayerDomain> getLayerDomains() {
        return layerDomains;
    }

    public Double getStartFrequncy() {
        return startFrequncy;
    }

    public Double getEndFrequncy() {
        return endFrequncy;
    }

    public Long getId() {
        return id;
    }

    public static NanoAntennaColumnDomain getInstance(Integer topType, Double topConstant, Integer downType,
                                                      Double downConstant, Integer lightType, Integer source,
                                                      Integer workType, Double x, Double y, Double angle, Double h, Double p, Double minH,
                                                      Double startFrequncy, Double endFrequncy, List<NanoAntennaLayerDomain> layerDomains
                                                      ){
        return new NanoAntennaColumnDomain(topType,topConstant, downType, downConstant,lightType, source, workType,x,y,angle,h,p,minH,startFrequncy,endFrequncy,layerDomains);
    }

    protected NanoAntennaColumnDomain (Integer topType,Double topConstant,Integer downType,Double downConstant,
                                       Integer lightType,Integer source,Integer workType,Double x,Double y,Double angle,Double h,Double p,Double minH,
                                       Double startFrequncy,Double endFrequncy,List<NanoAntennaLayerDomain> layerDomains){
        this.topType=topType;
        this.topConstant=topConstant;
        this.downType=downType;
        this.downConstant=downConstant;
        this.lightType=lightType;
        this.source=source;
        this.workType=workType;
        this.x=x;
        this.y=y;
        this.angle=angle;
        this.h=h;
        this.p=p;
        this.minH=minH;
        this.startFrequncy=startFrequncy;
        this.endFrequncy=endFrequncy;
        this.startL= DoubleUtil.div(300000d, startFrequncy, 4);
        this.endL=DoubleUtil.div(300000d, endFrequncy, 4);
        this.layerDomains=layerDomains;





    }




}
