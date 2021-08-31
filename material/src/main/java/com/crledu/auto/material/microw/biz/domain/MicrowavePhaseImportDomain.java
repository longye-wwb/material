package com.crledu.auto.material.microw.biz.domain;

import com.crledu.auto.material.base.domain.AbstructImportDomain;
import com.crledu.auto.material.base.dto.ImportItemFormData;
import com.crledu.auto.material.base.service.annotation.ColumnName;
import com.crledu.auto.material.base.service.annotation.DataName;
import com.crledu.auto.material.base.service.annotation.TableConstructor;
import com.crledu.auto.material.microw.biz.dto.CrossPolarizationDataDto;
import com.crledu.auto.material.microw.biz.dto.MicrowavePhaseImportFormDto;

import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 微波宽带相位调控
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 16:31
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class MicrowavePhaseImportDomain extends AbstructImportDomain {

    /**
     * 金属厚度
     */
    private Float thickness;

    /**
     * 工字型臂宽度角度
     */
    private Float armR;

    /**
     * 工字型臂线宽
     */
    private Float armY;

    /**
     * 反射板距离系数
     */
    private Float laylerx;

    /**
     * 周期系数
     */
    private Float period;

    /**
     * 基板介电常数
     */
    private Float permittivity;

    /**
     * 工字型矩形线宽
     */
    private Float rectY;

    /**
     * 工字型矩形宽度（两侧）
     */
    private Float rectX;

    /**
     * 工字型矩形宽度（中间）
     */
    private Float rectX2;

    /**
     * 基板厚度
     */
    private Float subH;

    /**
     * 入射角
     */
    private Float lightAngle;

    private Integer lightType;

    /**
     * 工作方式
     */
    private Integer workingMode;

    /**
     * 交叉极化幅度数据内容
      */
    private List<CrossPolarizationDataDto> data;

    /**
     * 相对带宽
     */
    private Float bandwidth;

    @TableConstructor
    public MicrowavePhaseImportDomain(@ColumnName("armR") Float armR, @ColumnName("armY")Float armY, @ColumnName("laylerx")Float laylerx, @ColumnName("p1")Float period, @ColumnName("permittivity")Float permittivity,@ColumnName("rectX")Float rectX,@ColumnName("rectX2")Float rectX2,@ColumnName("subH")Float subH, @ColumnName("rectY")Float rectY,@ColumnName("bandwidth") Float bandwidth, MicrowavePhaseImportFormDto importItemFormData, Float[] waveLengths, @DataName("range")String[] ranges) {
        super(importItemFormData);
        this.lightAngle = importItemFormData.getLightAngle();
        this.lightType = importItemFormData.getLightType();
        this.thickness = importItemFormData.getThickness();
        this.workingMode = importItemFormData.getWorkingMode();
        this.armR = armR;
        this.armY = armY;
        this.laylerx = laylerx;
        this.period = period;
        this.permittivity = permittivity;
        this.rectX = rectX;
        this.rectX2 = rectX2;
        this.subH = subH;
        this.rectY = rectY;
        this.data = buildRangeData(waveLengths,ranges);
        this.bandwidth = bandwidth;
    }

    private List<CrossPolarizationDataDto> buildRangeData(Float[] x,String[]y){
        List<CrossPolarizationDataDto> result = new ArrayList<>();
        for(int i = 0 ; i < x.length;i++){
            CrossPolarizationDataDto dataDto = new CrossPolarizationDataDto();
            dataDto.setWavelength(x[i]);
            dataDto.setRange(Float.parseFloat(y[i]));
            result.add(dataDto);
        }
        return result;
    }

    public Float getThickness() {
        return thickness;
    }

    public Float getArmR() {
        return armR;
    }

    public Float getArmY() {
        return armY;
    }

    public Float getLaylerx() {
        return laylerx;
    }

    public Float getPeriod() {
        return period;
    }

    public Float getPermittivity() {
        return permittivity;
    }

    public Float getRectY() {
        return rectY;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public Integer getWorkingMode() {
        return workingMode;
    }

    public List<CrossPolarizationDataDto> getData() {
        return data;
    }

    public Float getRectX() {
        return rectX;
    }

    public Float getRectX2() {
        return rectX2;
    }

    public Float getSubH() {
        return subH;
    }

    public Integer getLightType() {
        return lightType;
    }

    public Float getBandwidth() {
        return bandwidth;
    }
}
