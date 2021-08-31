package com.crledu.auto.material.grating.repository.dto;

import com.crledu.auto.material.base.dto.AbsorbingItemDto;

import java.util.List;

/**
 ************************************************************
 * @Description: 红外光栅
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/2 11:02
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class InfraredGratingDataDto {

    private Long importId;
    private Integer dataFrom;
    private Float width;
    private Float height;
    private Float space;
    private Float lightAngle;
    private String material;
    private Integer lightType;
    private List<AbsorbingItemDto> absorbingItemDtos;
    private Float bandwidth;

    public InfraredGratingDataDto() {
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getSpace() {
        return space;
    }

    public void setSpace(Float space) {
        this.space = space;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }

    public List<AbsorbingItemDto> getAbsorbingItemDtos() {
        return absorbingItemDtos;
    }

    public void setAbsorbingItemDtos(List<AbsorbingItemDto> absorbingItemDtos) {
        this.absorbingItemDtos = absorbingItemDtos;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public Float getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Float bandwidth) {
        this.bandwidth = bandwidth;
    }
}
