package com.crledu.auto.material.microw.biz.domain;

import com.crledu.auto.material.base.domain.AbstructImportDomain;
import com.crledu.auto.material.base.service.annotation.ColumnName;
import com.crledu.auto.material.base.service.annotation.DataName;
import com.crledu.auto.material.base.service.annotation.TableConstructor;
import com.crledu.auto.material.microw.biz.dto.MicrowaveAmplitudeImportFormDto;
import com.crledu.auto.material.microw.biz.dto.PhaseDifferenceDataDto;

import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 微波宽带偏振转换业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 10:17
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class MicrowaveAmplitudeImportDomain extends AbstructImportDomain {

    /**
     * 两端线宽
     */
    private Float width;

    /**
     * 中间电容线长
     */
    private Float lineLength;

    /**
     * 中间电容线宽
     */
    private Float lineWidth;

    /**
     * 介质材料介电常数
     */
    private Float constant;

    /**
     * 介质材料的厚度
     */
    private Float mediumThickness;

    /**
     * 介质材料x方向尺寸
     */
    private Float xPath;

    /**
     * 介质材料y方向尺寸
     */
    private Float yPath;

    /**
     * 电容缝隙宽度
     */
    private Float gapWidth;

    /**
     * 入射角
     */
    private Float lightAngle;

    /**
     * 工作方式
     */
    private Integer workingMode;

    /**
     * 入射光源偏振态
     */
    private Integer amplitudeType;

    /**
     * 相位差数据
     */
    private List<PhaseDifferenceDataDto> data;

    /**
     * 相对带宽
     */
    private Float bandwidth;

    @TableConstructor
    public MicrowaveAmplitudeImportDomain(@ColumnName("w1") Float width,@ColumnName("w2")Float lineWidth,@ColumnName("m2") Float constant,@ColumnName("t2") Float mediumThickness,@ColumnName("px") Float xPath,@ColumnName("py") Float yPath,@ColumnName("g") Float gapWidth,@ColumnName("bandwidth") Float bandwidth, MicrowaveAmplitudeImportFormDto importItemFormData, Float[] waveLengths, @DataName("x")String[] phaseXArr, @DataName("y")String[] phaseYArr) {
        super(importItemFormData);
        this.lightAngle = importItemFormData.getLightAngle();
        this.workingMode = importItemFormData.getWorkingMode();
        this.amplitudeType = importItemFormData.getAmplitudeType();
        this.constant = constant;
        this.gapWidth = gapWidth;
        this.lineLength = 2f;
        this.lineWidth = lineWidth;
        this.mediumThickness = mediumThickness;
        this.width = width;
        this.xPath = xPath;
        this.yPath = yPath;
        this.bandwidth = bandwidth;
        this.data = buildDifferenceData(waveLengths,phaseXArr,phaseYArr);
    }

    private List<PhaseDifferenceDataDto> buildDifferenceData(Float[] waveLength,String[] phaseXArr,String[] phaseYArr){
        List<PhaseDifferenceDataDto> list = new ArrayList<>();
        for(int i = 0 ; i< waveLength.length ; i++){
            PhaseDifferenceDataDto dataDto = new PhaseDifferenceDataDto(waveLength[i],Float.parseFloat(phaseXArr[i]),Float.parseFloat(phaseYArr[i]));
            list.add(dataDto);
        }
        return list;
    }

    public Float getWidth() {
        return width;
    }

    public Float getLineLength() {
        return lineLength;
    }

    public Float getLineWidth() {
        return lineWidth;
    }

    public Float getConstant() {
        return constant;
    }

    public Float getMediumThickness() {
        return mediumThickness;
    }

    public Float getxPath() {
        return xPath;
    }

    public Float getyPath() {
        return yPath;
    }

    public Float getGapWidth() {
        return gapWidth;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public Integer getWorkingMode() {
        return workingMode;
    }

    public List<PhaseDifferenceDataDto> getData() {
        return data;
    }

    public Integer getAmplitudeType() {
        return amplitudeType;
    }

    public Float getBandwidth() {
        return bandwidth;
    }
}
