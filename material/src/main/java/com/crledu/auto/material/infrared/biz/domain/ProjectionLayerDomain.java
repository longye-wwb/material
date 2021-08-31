package com.crledu.auto.material.infrared.biz.domain;

import com.crledu.auto.material.infrared.biz.dto.ProjectionDataItemDto;
import com.crledu.auto.web.exception.RestRuntimeException;

import java.util.List;

/**
 ************************************************************
 * @Description: 微波透射层
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 10:01
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ProjectionLayerDomain {

    private Long id;

    private Long importId;

    /**
     * 基底
     */
    private ProjectionLayerBaseDomain baseDomain;

    /**
     * 介质
     */
    private ProjectionLayerDielectricDomain dielectricDomain;

    /**
     * 金属贴片
     */
    private ProjectionLayerMetalPatchDomain metalPatchDomain;

    /**
     * 红外辐射率
     */
    private Float infraredEmissivity;

    /**
     * 数据来源
     */
    private Integer dataFrom;

    /**
     * 入射角
     */
    private Float lightAngle;

    /**
     * 光谱透射数据
     */
    private List<ProjectionDataItemDto> projectionDataItemDtoList;

    private Boolean saveData;


    public ProjectionLayerDomain(Long importId,ProjectionLayerBaseDomain baseDomain, ProjectionLayerDielectricDomain dielectricDomain, ProjectionLayerMetalPatchDomain metalPatchDomain,Integer dataFrom, Float lightAngle,List<ProjectionDataItemDto> projectionDataItemDtoList,Boolean saveData) {
        if(metalPatchDomain == null || dielectricDomain == null){
            throw new RestRuntimeException("透射层缺少贴片层或介质层参数","1100000001");
        }
        this.importId = importId;
        this.baseDomain = baseDomain;
        this.dielectricDomain = dielectricDomain;
        this.metalPatchDomain = metalPatchDomain;
        this.infraredEmissivity = computeInfraredEmissivity();
        this.dataFrom = dataFrom;
        this.lightAngle = lightAngle;
        this.projectionDataItemDtoList = projectionDataItemDtoList;
    }

    private Float computeInfraredEmissivity(){
        /**
         *  ε1*t+ε2*(1-t)
         *  没有基底用材料三红外发射率ε3代替ε2
         */
        Float scale = 1.0F - metalPatchDomain.getProportionOfMetals();
        if(baseDomain == null|| baseDomain.getInfraredEmissivity() == null){
            Float result = metalPatchDomain.getInfraredEmissivity() * metalPatchDomain.getProportionOfMetals() + dielectricDomain.getInfraredEmissivity() * scale;
            return result;
        }else{
            Float result = metalPatchDomain.getInfraredEmissivity() * metalPatchDomain.getProportionOfMetals() + baseDomain.getInfraredEmissivity() * scale;
            return result;
        }
    }

    public static ProjectionLayerDomain getInstance(Long importId,ProjectionLayerBaseDomain baseDomain, ProjectionLayerDielectricDomain dielectricDomain, ProjectionLayerMetalPatchDomain metalPatchDomain,Integer dataFrom, Float lightAngle,List<ProjectionDataItemDto> projectionDataItemDtoList,Boolean saveData){
        return new ProjectionLayerDomain(importId,baseDomain, dielectricDomain, metalPatchDomain, dataFrom, lightAngle, projectionDataItemDtoList,saveData);
    }

    public Boolean getSaveData() {
        return saveData;
    }

    public Long getId() {
        return id;
    }

    public Long getImportId() {
        return importId;
    }

    public ProjectionLayerBaseDomain getBaseDomain() {
        return baseDomain;
    }

    public ProjectionLayerDielectricDomain getDielectricDomain() {
        return dielectricDomain;
    }

    public ProjectionLayerMetalPatchDomain getMetalPatchDomain() {
        return metalPatchDomain;
    }

    public Float getInfraredEmissivity() {
        return infraredEmissivity;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public List<ProjectionDataItemDto> getProjectionDataItemDtoList() {
        return projectionDataItemDtoList;
    }
}
