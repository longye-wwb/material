package com.crledu.auto.material.microwaveIntegration.biz.domain;

import com.crledu.auto.material.base.domain.AbstructImportDomain;
import com.crledu.auto.material.base.service.annotation.ColumnName;
import com.crledu.auto.material.base.service.annotation.DataName;
import com.crledu.auto.material.base.service.annotation.TableConstructor;
import com.crledu.auto.material.microwaveIntegration.biz.dto.IntegrationDto;
import com.crledu.auto.material.microwaveIntegration.biz.dto.MicrowaveIntegrationImportDto;

import java.util.ArrayList;
import java.util.List;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/11
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class MicrowaveInterationDomain extends AbstructImportDomain {

    //光源类型
    private Integer lightType;
    //入射角度
    private Float lightAngle;
    //工作方式
    private Integer workType;
    //起始频率
    private Float startFrequency;
    //结束频率
    private Float endFrequency;
    //介电常数
    private Float dielectric;
    //缝宽
    private Float g0;
    //金属条长度
    private Float l0;
    //周期
    private Float p;
    //方形环外环边长
    private Float l;
    //方形环之间间隔
    private Float g;
    //基底宽度
    private Float s;
    //方形环宽度一层
    private Float s1;
    //方形环宽度二层
    private Float s2;
    //方形环宽度三层
    private Float s3;
    //基底材料方阻
    private Float r;
    //方形环材料一层方阻
    private Float r1;
    //方形环材料二层方阻
    private Float r2;
    //方形环材料三层方阻
    private Float r3;
    //基底高度
    private Float h;
    //二层与一层间隔
    private Float h1;
    //二层与三层间隔
    private Float h2;
    //三层与基底层间隔
    private Float h3;

    private List<IntegrationDto> integrationDtos;

    /**
     * 透射相对带宽
     */
    private Float tBandwidth;

    /**
     * 吸收相对带宽
     */
    private Float aBandwidth;




    public Integer getLightType() {
        return lightType;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public Integer getWorkType() {
        return workType;
    }

    public Float getStartFrequency() {
        return startFrequency;
    }

    public Float getEndFrequency() {
        return endFrequency;
    }

    public Float getDielectric() {
        return dielectric;
    }

    public Float getG0() {
        return g0;
    }

    public Float getL0() {
        return l0;
    }

    public Float getP() {
        return p;
    }

    public Float getL() {
        return l;
    }

    public Float getG() {
        return g;
    }

    public Float getS() {
        return s;
    }

    public Float getS1() {
        return s1;
    }

    public Float getS2() {
        return s2;
    }

    public Float getS3() {
        return s3;
    }

    public Float getR() {
        return r;
    }

    public Float getR1() {
        return r1;
    }

    public Float getR2() {
        return r2;
    }

    public Float getR3() {
        return r3;
    }

    public Float getH() {
        return h;
    }

    public Float getH1() {
        return h1;
    }

    public Float getH2() {
        return h2;
    }

    public Float getH3() {
        return h3;
    }

    public Float gettBandwidth() {
        return tBandwidth;
    }

    public Float getaBandwidth() {
        return aBandwidth;
    }

    @TableConstructor
    public MicrowaveInterationDomain(MicrowaveIntegrationImportDto importDto, @ColumnName("g0")Float g0, @ColumnName("l0")Float l0, @ColumnName("s3")Float s3, @ColumnName("s")Float s,
                                     @ColumnName("R1")Float r1, @ColumnName("R")Float r, @ColumnName("h1")Float h1, @ColumnName("h")Float h,@ColumnName("Tbandwidth") Float tBandwidth,@ColumnName("Abandwidth") Float aBandwidth,
                                     Float[] waveLengths, @DataName("broadband") String[] broadband, @DataName("narrowband")String[] narrowband){

        super(importDto);
        this.lightType=importDto.getLightType();
        this.lightAngle=importDto.getLightAngle();
        this.workType=importDto.getWorkType();
        this.dielectric=importDto.getDielectric();
        this.p = importDto.getP();
        this.g0=g0;
        this.l0=l0;
        this.s=s;
        this.s1=s;
        this.s2=s;
        this.s3=s3;
        this.r=r;
        this.r1=r1;
        this.r2=r;
        this.r3=r;
        this.h=h;
        this.h1=h1;
        this.h2=h;
        this.h3=h;
        this.startFrequency=waveLengths[0];
        this.endFrequency=waveLengths[waveLengths.length-1];
        this.integrationDtos=new ArrayList<>();
        this.tBandwidth = tBandwidth;
        this.aBandwidth = aBandwidth;

        for (int i=0;i<waveLengths.length;i++){
            IntegrationDto breadthWaveDto = new IntegrationDto(waveLengths[i],Float.valueOf(broadband[i]),Float.valueOf(narrowband[i]));
            integrationDtos.add(breadthWaveDto);
        }

    }

    public List<IntegrationDto> getIntegrationDtos() {
        return integrationDtos;
    }
}
