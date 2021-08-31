package com.crledu.auto.material.cooling.biz.domain;

import com.crledu.auto.material.cooling.biz.dto.AbsorbingItemDto;
import com.crledu.auto.material.cooling.biz.dto.CoolingMaterialCreateDto;

import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 辐射制冷材料
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/20 11:17
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class CoolingMaterailDataDomain {

    private Long id;

    private Long importId;

    /**
     * 结构类型：1、多层膜、2、双层圆柱
     */
    private Integer type;

    /**
     * 厚度
     */
    private Float thickness;

    /**
     * 周期
     */
    private Float period;

    /**
     * 基底材料
     */
    private MaterailLayerDomain baseMaterial;

    /**
     * 膜或者两层圆柱的材料
     */
    private List<MaterailLayerDomain> layers;

    /**
     * 入射光类型
     */
    private Integer lightType;

    /**
     * 数据来源
     */
    private Integer dataForm;

    /**
     * 入射角
     */
    private Float lightAngle;

    /**
     * 工作模式
     */
    private Integer workingMode;

    /**
     * 吸收率数据
     */
    private  List<AbsorbingItemDto> absorptivity;

    private Boolean saveData;

    public CoolingMaterailDataDomain(Long id, Long importId, Integer type, Float thickness, Float period, MaterailLayerDomain baseMaterial, List<MaterailLayerDomain> layers, Integer lightType, Integer dataForm, Float lightAngle, Integer workingMode, List<AbsorbingItemDto> absorptivity) {
        this.id = id;
        this.importId = importId;
        this.type = type;
        this.thickness = thickness;
        this.period = period;
        this.baseMaterial = baseMaterial;
        this.layers = layers;
        this.lightType = lightType;
        this.dataForm = dataForm;
        this.lightAngle = lightAngle;
        this.workingMode = workingMode;
        this.absorptivity = absorptivity;
    }

    private CoolingMaterailDataDomain(Long importId, Integer type, Float thickness, Float p, MaterailLayerDomain baseMaterial, List<MaterailLayerDomain> layers, Integer lightType, Float lightAngle, Integer workingMode, List<AbsorbingItemDto> absorptivity, Integer dataFrom) {
        this.type = type;
        this.thickness = thickness;
        this.period = p;
        this.baseMaterial = baseMaterial;
        this.layers = layers;
        this.lightType = lightType;
        this.lightAngle = lightAngle;
        this.workingMode = workingMode;
        this.absorptivity = absorptivity;
        this.dataForm = dataFrom;
        this.importId = importId;
    }

    public static CoolingMaterailDataDomain getInstance(Long importId,Integer type, Float thickness, Float p, MaterailLayerDomain baseMaterial, List<MaterailLayerDomain> layers, Integer lightType, Float lightAngle, Integer workingMode, List<AbsorbingItemDto> absorptivity,Integer dataForm){
        return new CoolingMaterailDataDomain(importId,type,thickness,p,baseMaterial,layers,lightType,lightAngle,workingMode,absorptivity,dataForm);
    }

    public static CoolingMaterailDataDomain getInstance(CoolingMaterialCreateDto createDto){
        Float thickness = 0f;
        List<MaterailLayerDomain> layers = new ArrayList<>();
        for(int i = 0;i<createDto.getLayers();i++){
            String material = (i + 1) % 2 == 1 ? createDto.getFirstMaterial():createDto.getSecondMaterial();
            thickness += createDto.getThicknessList().get(i);
            MaterailLayerDomain layerDomain = null;
            if(createDto.getDiameterList()!=null){
                layerDomain = new MaterailLayerDomain(i,material,createDto.getThicknessList().get(i),createDto.getDiameterList().get(i));
            }else{
                layerDomain = new MaterailLayerDomain(i,material,createDto.getThicknessList().get(i),null);
            }
            layers.add(layerDomain);
        }
        MaterailLayerDomain baseLayer = new MaterailLayerDomain(0,createDto.getBaseMaterial(),null,null);
        return new CoolingMaterailDataDomain(createDto.getImportId(),createDto.getType(),thickness,createDto.getPeriod(),baseLayer,layers,createDto.getLightType(),createDto.getLightAngle(),createDto.getWorkingMode(),createDto.getAbsorbingItemDtos(),createDto.getDataFrom());
    }

    public Long getId() {
        return id;
    }

    public Integer getType() {
        return type;
    }

    public Float getThickness() {
        return thickness;
    }

    public MaterailLayerDomain getBaseMaterial() {
        return baseMaterial;
    }

    public List<MaterailLayerDomain> getLayers() {
        return layers;
    }

    public Integer getLightType() {
        return lightType;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public Integer getWorkingMode() {
        return workingMode;
    }

    public Float getPeriod() {
        return period;
    }

    public List<AbsorbingItemDto> getAbsorptivity() {
        return absorptivity;
    }

    public Integer getDataForm() {
        return dataForm;
    }

    public Long getImportId() {
        return importId;
    }

    public Boolean getSaveData() {
        return saveData;
    }
}
