package com.crledu.auto.material.second.biz.domain;

import com.crledu.auto.material.base.domain.AbstructImportDomain;
import com.crledu.auto.material.base.dto.ImportItemFormData;
import com.crledu.auto.material.base.service.annotation.ColumnName;
import com.crledu.auto.material.base.service.annotation.DataName;
import com.crledu.auto.material.second.biz.dto.BoundaryImportDto;
import com.crledu.auto.material.second.biz.dto.LightDataItemDto;
import com.crledu.auto.material.second.data.dto.BoundaryDataItemDto;

import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 边界优化超透镜业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 21:58
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class BoundaryDomain extends AbstructImportDomain {

    private Long id;

    /**
     * 偏振类型：1、x偏振；2、y偏振
     */
    private Integer type;

    /**
     * 纳米天线结构类型：1、方形
     */
    private Integer shape;

    /**
     * 纳米天线介电常数
     */
    private Float constant;

    /**
     * 基底结构类型：1、正方形
     */
    private Integer baseShape;

    /**
     * 基底介电常数
     */
    private Float baseConstant;

    /**
     * 天线结构长轴
     */
    private Float l;

    /**
     * 天线结构短轴
     */
    private Float w;

    /**
     * 天线结构高速
     */
    private Float h2;

    /**
     * 基底厚度
     */
    private Float h1;

    /**
     * 基底边长
     */
    private Float p;

    /**
     * 入射光源
     */
    private Integer lightType;

    /**
     * 入射角
     */
    private Double lightAngle;

    /**
     * 工作波长
     */
    private Float workingWave;

    /**
     * 工作方式
     */
    private Integer workType;

    /**
     * 焦距
     */
    private Float focalLength;

    /**
     * 全模结构边长
     */
    private Float length;

    /**
     * 衍射效率
     */
    private Float diffractionEfficiency;

    /**
     * 聚焦效率
     */
    private Float focalEfficiency;

    /**
     * 理想衍射效率
     */
    private Float hopefulDiffractionEfficiency;

    /**
     * 理想聚焦效率
     */
    private Float hopefulFocalEfficiency;

    /**
     * 器件透过率
     */
    private Float Transmittance;

    /**
     * 中心点很坐标
     */
    private Float centerX;

    /**
     * 中心点纵坐标
     */
    private Float centery;

    private List<LightDataItemDto> lightData;

    public BoundaryDomain(BoundaryImportDto importItemFormData, @ColumnName("x")Float x, @ColumnName("y")Float y, @ColumnName("l")Float l, @ColumnName("w")Float w, @ColumnName("h2")Float h2, @ColumnName("h1")Float h1, @ColumnName("p") Float p, Float[] waveLengths, @DataName("real") String[] real, @DataName("empty") String[] empty) {
        super(importItemFormData);
        this.l = l;
        this.w = w;
        this.h2 = h2;
        this.h1 = h1;
        this.p = p;
        this.centerX = x;
        this.centery = y;

        //
        this.type = importItemFormData.getType();
        this.shape = importItemFormData.getShape();
        this.constant = importItemFormData.getConstant();
        this.baseShape = importItemFormData.getBaseShape();
        this.baseConstant = importItemFormData.getBaseConstant();
        this.lightType = importItemFormData.getLightType();
        this.lightAngle = importItemFormData.getLightAngle();
        this.workingWave = importItemFormData.getWorkingWave();
        this.workType = importItemFormData.getWorkType();
        this.focalLength = importItemFormData.getFocalLength();
        this.length = importItemFormData.getLength();
        this.diffractionEfficiency = importItemFormData.getDiffractionEfficiency();
        this.focalEfficiency = importItemFormData.getFocalEfficiency();
        this.hopefulDiffractionEfficiency = importItemFormData.getHopefulDiffractionEfficiency();
        this.hopefulFocalEfficiency = importItemFormData.getHopefulFocalEfficiency();
        this.Transmittance = importItemFormData.getTransmittance();

        //构造光谱数据
        List<LightDataItemDto> dataItemDtos = new ArrayList<>();
        for(int i = 0;i<waveLengths.length;i++){
            LightDataItemDto itemDto = new LightDataItemDto();
            itemDto.setWaveLength(waveLengths[i]);
            itemDto.setReal(Float.parseFloat(real[i]));
            itemDto.setEmpty(Float.parseFloat(empty[i]));
            dataItemDtos.add(itemDto);
        }
        this.lightData = dataItemDtos;
    }

    public Long getId() {
        return id;
    }

    public Integer getType() {
        return type;
    }

    public Integer getShape() {
        return shape;
    }

    public Float getConstant() {
        return constant;
    }

    public Integer getBaseShape() {
        return baseShape;
    }

    public Float getBaseConstant() {
        return baseConstant;
    }

    public Float getL() {
        return l;
    }

    public Float getW() {
        return w;
    }

    public Float getH2() {
        return h2;
    }

    public Float getH1() {
        return h1;
    }

    public Float getP() {
        return p;
    }

    public Integer getLightType() {
        return lightType;
    }

    public Double getLightAngle() {
        return lightAngle;
    }

    public Float getWorkingWave() {
        return workingWave;
    }

    public Integer getWorkType() {
        return workType;
    }

    public Float getFocalLength() {
        return focalLength;
    }

    public Float getLength() {
        return length;
    }

    public Float getDiffractionEfficiency() {
        return diffractionEfficiency;
    }

    public Float getFocalEfficiency() {
        return focalEfficiency;
    }

    public Float getHopefulDiffractionEfficiency() {
        return hopefulDiffractionEfficiency;
    }

    public Float getHopefulFocalEfficiency() {
        return hopefulFocalEfficiency;
    }

    public Float getTransmittance() {
        return Transmittance;
    }

    public Float getCenterX() {
        return centerX;
    }

    public Float getCentery() {
        return centery;
    }

    public List<LightDataItemDto> getLightData() {
        return lightData;
    }
}
