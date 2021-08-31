package com.crledu.auto.material.second.biz.domain;

import com.crledu.auto.material.base.domain.AbstructImportDomain;
import com.crledu.auto.material.base.service.annotation.ColumnName;
import com.crledu.auto.material.base.service.annotation.DataName;
import com.crledu.auto.material.base.service.annotation.TableConstructor;
import com.crledu.auto.material.second.biz.dto.SplitterImportDto;
import com.crledu.auto.material.second.biz.dto.SplitterLightDataDto;

import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 偏振分束功能波导业务实体
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/18 12:08
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class SplitterDomain extends AbstructImportDomain {

    private Long id;
    private String struct;
    private Integer width;
    private Integer height;
    private String material;
    private Float waveStart;
    private Float waveStop;
    private List<SplitterLightDataDto> data;

    @TableConstructor
    public SplitterDomain(SplitterImportDto importItemFormData, @ColumnName("struct")String structMap, Float[] wavelengths, @DataName("te")String[] tes, @DataName("tm")String[] tms) {
        super(importItemFormData);
        this.struct = structMap;

        this.height = importItemFormData.getHeight();
        this.width = importItemFormData.getWidth();
        this.material = importItemFormData.getMaterial();

        this.waveStart = wavelengths[0];
        this.waveStop = wavelengths[wavelengths.length - 1];
        List<SplitterLightDataDto> dataDtos = new ArrayList<>();
        for(int i=0;i<wavelengths.length;i++){
            SplitterLightDataDto dataDto = new SplitterLightDataDto();
            dataDto.setWaveLength(wavelengths[i]);
            dataDto.setTe(Float.parseFloat(tes[i]));
            dataDto.setTm(Float.parseFloat(tms[i]));
            dataDtos.add(dataDto);
        }
        this.data = dataDtos;
    }

    public Long getId() {
        return id;
    }

    public String getStruct() {
        return struct;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public String getMaterial() {
        return material;
    }

    public Float getWaveStart() {
        return waveStart;
    }

    public Float getWaveStop() {
        return waveStop;
    }

    public List<SplitterLightDataDto> getData() {
        return data;
    }
}
