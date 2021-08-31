package com.crledu.auto.material.grating.biz.domain;

import com.crledu.auto.material.base.domain.AbstructImportDomain;
import com.crledu.auto.material.base.dto.AbsorbingItemDto;
import com.crledu.auto.material.base.dto.ImportItemFormData;
import com.crledu.auto.material.base.service.annotation.ColumnName;
import com.crledu.auto.material.base.service.annotation.DataName;
import com.crledu.auto.material.base.service.annotation.TableConstructor;
import com.crledu.auto.material.grating.biz.dto.InfraredGratingFormDataDto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 红外光栅业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/30 18:03
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class InfraredGratingDomain extends AbstructImportDomain {

    private String material;
    private Float width;
    private Float height;
    private Float space;
    private Integer lightType;

    private Float lightAngle;

    private List<AbsorbingItemDto> absorbingItemDtos;

    private Float bandwidth;


    @TableConstructor
    public InfraredGratingDomain(@ColumnName("d") Float width , @ColumnName("h") Float height, @ColumnName("g") Float space,@ColumnName("bandwidth")Float bandwidth, InfraredGratingFormDataDto importItemFormData,Float[] waveLengths, @DataName("absorbing") String[] absorbing) {
        super(importItemFormData);
        this.lightAngle = importItemFormData.getLightAngle();
        this.material = importItemFormData.getMaterial().trim();
        this.lightType = importItemFormData.getLightType();
        this.width = width;
        this.height = height;
        this.space = space;
        this.bandwidth = bandwidth;
        this.absorbingItemDtos = new ArrayList<>();
        for(int i = 1;i < waveLengths.length;i++){
            AbsorbingItemDto itemDto = new AbsorbingItemDto();
            itemDto.setWaveLength(waveLengths[i]);
            itemDto.setAbsorbing(Float.parseFloat(absorbing[i]));
            absorbingItemDtos.add(itemDto);
        }
    }

    public Float getWidth() {
        return width;
    }

    public Float getHeight() {
        return height;
    }

    public Float getSpace() {
        return space;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public List<AbsorbingItemDto> getAbsorbingItemDtos() {
        return absorbingItemDtos;
    }

    public String getMaterial() {
        return material;
    }

    public Integer getLightType() {
        return lightType;
    }

    public Float getBandwidth() {
        return bandwidth;
    }
}
