package com.crledu.auto.material.microwave.biz.domain;

import com.crledu.auto.material.base.domain.AbstructImportDomain;
import com.crledu.auto.material.base.service.annotation.ColumnName;
import com.crledu.auto.material.base.service.annotation.DataName;
import com.crledu.auto.material.base.service.annotation.TableConstructor;
import com.crledu.auto.material.microwave.biz.dto.AbsorptionRateDto;
import com.crledu.auto.material.microwave.biz.dto.MicrowaveImportDto;

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
 * @Date: 2020/12/10
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class MicrowaveAbsorbingDomain extends AbstructImportDomain {

    //结构材料
    private Integer materialStructure;
    //总厚度
    private Float totalThickness;
    //填充材料
    private Integer filler;
    //材料层数，layer
    private Integer layer;
    //周期p
    private Float p;
    //间隙mm
    private Float g;
    //第一层线宽
    private Float s1;
    //第二层线宽
    private Float s2;
    //第三层线宽
    private Float s3;
    //第一层高度
    private Float h1;
    //第二层高度
    private Float h2;
    //第三层高度
    private Float h3;

    private Float rs1;
    private Float rs2;
    private Float rs3;
    private Integer lightType;
    private Float lightAngle;
    private Float startWave;
    private Float endWave;
    private Integer workType;
    private List<AbsorptionRateDto> absorptionRateDtos;

    private Float bandwidth;

    public Integer getMaterialStructure() {
        return materialStructure;
    }

    public Float getTotalThickness() {
        return totalThickness;
    }

    public Integer getFiller() {
        return filler;
    }

    public Integer getLayer() {
        return layer;
    }

    public Float getP() {
        return p;
    }

    public Float getS1() {
        return s1;
    }

    public Float getS2() {
        return s2;
    }

    public Float getG() {
        return g;
    }

    public Float getS3() {
        return s3;
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

    public Float getRs1() {
        return rs1;
    }

    public Float getRs2() {
        return rs2;
    }

    public Float getRs3() {
        return rs3;
    }

    public Integer getLightType() {
        return lightType;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public Float getStartWave() {
        return startWave;
    }

    public Float getEndWave() {
        return endWave;
    }

    public Integer getWorkType() {
        return workType;
    }

    public List<AbsorptionRateDto> getAbsorptionRateDtos() {
        return absorptionRateDtos;
    }

    public Float getBandwidth() {
        return bandwidth;
    }

    @TableConstructor
    public MicrowaveAbsorbingDomain(MicrowaveImportDto importDto, @ColumnName("p")Float p,@ColumnName("g")Float g,@ColumnName("s_1")Float s1,@ColumnName("s_2")Float s2,@ColumnName("s_3")Float s3,@ColumnName("h_1")Float h1,@ColumnName("h_2")Float h2,@ColumnName("h_3")Float h3,@ColumnName("Rs_1")Float rs1,@ColumnName("Rs_2")Float rs2,@ColumnName("Rs_3")Float rs3,@ColumnName("layer")Integer layer,@ColumnName("bandwidth")Float bandwidth, Float[] waveLengths,@DataName("microwave") String[] data){
        super(importDto);
        this.materialStructure=importDto.getMaterialStructure();
        this.lightType=importDto.getLightType();
        this.lightAngle=importDto.getLightAngle();
        this.workType=importDto.getWorkType();
        this.p=p;
        this.g=g;
        this.s1=s1;
        this.s2=s2;
        this.s3 = s3;
        this.h1 = h1;
        this.h2 = h2;
        this.h3 = h3;
        this.rs1 = rs1;
        this.rs2 = rs2;
        this.rs3 = rs3;
        this.filler=importDto.getFiller();
        this.layer=layer;
        this.startWave=waveLengths[0];
        this.endWave=waveLengths[waveLengths.length-1];
        this.absorptionRateDtos=new ArrayList<>();
        this.bandwidth = bandwidth;
        for (int i=0;i<waveLengths.length;i++){
            AbsorptionRateDto breadthWaveDto = new AbsorptionRateDto(waveLengths[i],Float.valueOf(data[i]));
            absorptionRateDtos.add(breadthWaveDto);
        }
    }
}
