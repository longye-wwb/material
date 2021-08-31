package com.crledu.auto.material.infrared.biz.dto;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

/**
 ************************************************************
 * @Description: 红外反射微波吸收层导入数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/23 10:59
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ProjectionLayerImportDto {

    /**
     * 导入数据历史
     */
    private Long id;

    /**
     * 导入人
     */
    private Long creator;

    /**
     * 结构数据文件
     */
    private MultipartFile struct;

    /**
     * 曲线数据
     */
    private MultipartFile data;

    /**
     * 数据来源
     */
    private Integer dataFrom;

    /**
     * 入射角
     */
    private Float lightAngle;


    /**
     * 贴片层材料
     */
    private String PatchMaterial;

    /**
     * 贴片层红外发射率
     */
    private Float patchEmissivity;

    /**
     * 基底层材料
     */
    private String baseMaterial;


    /**
     * 基底层介电常数
     */
    private Float baseDielectric;

    /**
     * 基底层红外发射率
     */
    private Float baseEmissivity;

    /**
     * 介质层材料
     */
    private String dielectricMaterial;

    /**
     * 介质层介电常数
     */
    private Float dielectricConstant;

    /**
     * 介质层红外辐射
     */
    private Float dielectricEmissivity;

    /**
     * 模拟程序
     */
    private MultipartFile process;

    private Boolean saveData;

    public ProjectionLayerImportDto() {
    }

    public MultipartFile getStruct() {
        return struct;
    }

    public void setStruct(MultipartFile struct) {
        this.struct = struct;
    }

    public MultipartFile getData() {
        return data;
    }

    public void setData(MultipartFile data) {
        this.data = data;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }

    public String getPatchMaterial() {
        return PatchMaterial;
    }

    public void setPatchMaterial(String patchMaterial) {
        PatchMaterial = patchMaterial;
    }

    public Float getPatchEmissivity() {
        return patchEmissivity;
    }

    public void setPatchEmissivity(Float patchEmissivity) {
        this.patchEmissivity = patchEmissivity;
    }

    public String getBaseMaterial() {
        return baseMaterial;
    }

    public void setBaseMaterial(String baseMaterial) {
        this.baseMaterial = baseMaterial;
    }

    public Float getBaseDielectric() {
        return baseDielectric;
    }

    public void setBaseDielectric(Float baseDielectric) {
        this.baseDielectric = baseDielectric;
    }

    public Float getBaseEmissivity() {
        return baseEmissivity;
    }

    public void setBaseEmissivity(Float baseEmissivity) {
        this.baseEmissivity = baseEmissivity;
    }

    public String getDielectricMaterial() {
        return dielectricMaterial;
    }

    public void setDielectricMaterial(String dielectricMaterial) {
        this.dielectricMaterial = dielectricMaterial;
    }

    public Float getDielectricConstant() {
        return dielectricConstant;
    }

    public void setDielectricConstant(Float dielectricConstant) {
        this.dielectricConstant = dielectricConstant;
    }

    public Float getDielectricEmissivity() {
        return dielectricEmissivity;
    }

    public void setDielectricEmissivity(Float dielectricEmissivity) {
        this.dielectricEmissivity = dielectricEmissivity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultipartFile getProcess() {
        return process;
    }

    public void setProcess(MultipartFile process) {
        this.process = process;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Boolean getSaveData() {
        return saveData;
    }

    public void setSaveData(Boolean saveData) {
        this.saveData = saveData;
    }
}
