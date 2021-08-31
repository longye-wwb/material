package com.crledu.auto.material.breath.biz.domain;

import com.crledu.auto.material.base.domain.AbstructImportDomain;
import com.crledu.auto.material.base.service.annotation.ColumnName;
import com.crledu.auto.material.base.service.annotation.DataName;
import com.crledu.auto.material.base.service.annotation.TableConstructor;
import com.crledu.auto.material.breath.biz.dto.BreadthImpotDto;
import com.crledu.auto.material.breath.biz.dto.BreadthWaveDto;

import java.util.ArrayList;
import java.util.List;

/**
 * ***********************************************************
 *
 * @Description: 宽窄微波对象
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/2
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class BreadthDomain extends AbstructImportDomain {


    //入射角
    private Float lightAngle;
    //工作波段
    private String workingBand;
    //结构domain
    private BreadthStructureDomain structureDomain;
    //基底domain
    private BreadthBaseDomain baseDomain;
    //介质domain
    private BreadthMediumDomain mediumDomain;

    private List<BreadthWaveDto> waveDtos;

    private Integer lightType;
    private Integer workMode;

    private Float bandwidth;


    public Float getLightAngle() {
        return lightAngle;
    }

    public String getWorkingBand() {
        return workingBand;
    }

    public BreadthStructureDomain getStructureDomain() {
        return structureDomain;
    }

    public BreadthBaseDomain getBaseDomain() {
        return baseDomain;
    }

    public BreadthMediumDomain getMediumDomain() {
        return mediumDomain;
    }

    public List<BreadthWaveDto> getWaveDtos() {
        return waveDtos;
    }

    public Integer getLightType() {
        return lightType;
    }

    public Integer getWorkMode() {
        return workMode;
    }

    public Float getBandwidth() {
        return bandwidth;
    }

    @TableConstructor
    public BreadthDomain(BreadthImpotDto formData, @ColumnName("p") Float period,@ColumnName("l") Float length,@ColumnName("w") Float width,@ColumnName("t2")Float thickness, @ColumnName("bandwidth")Float bandwidth,Float[] waveLengths, @DataName("curve") String[] data){
        super(formData);
        this.lightAngle=formData.getLightAngle();
        this.structureDomain=new BreadthStructureDomain(formData.getType(),formData.getStructureMaterial(),formData.getStructureThickness(),period,length,width);
        this.mediumDomain=new BreadthMediumDomain(formData.getMediumMaterial(),formData.getDielectric(),formData.getLoss(),thickness);
        this.baseDomain=new BreadthBaseDomain(formData.getBaseMaterial(),formData.getBaseThickness());
        this.waveDtos=new ArrayList<>();
        for (int i=0;i<waveLengths.length;i++){
            BreadthWaveDto breadthWaveDto = new BreadthWaveDto(waveLengths[i],Float.valueOf(data[i]));
            waveDtos.add(breadthWaveDto);
        }
        this.workingBand=waveLengths[0].toString()+'-'+waveLengths[waveLengths.length-1].toString();
        this.lightType = formData.getLightType();
        this.workMode = formData.getWorkMode();
        this.bandwidth = bandwidth;

    }

}
