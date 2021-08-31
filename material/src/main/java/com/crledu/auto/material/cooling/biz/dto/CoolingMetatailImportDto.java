package com.crledu.auto.material.cooling.biz.dto;

import io.swagger.annotations.ApiModel;
import org.springframework.web.multipart.MultipartFile;

@ApiModel("辐射制冷数据导入参数")
public class CoolingMetatailImportDto {

    private Long importId;

    /**
     * 导入数据的人
     */
    private Long creator;

    /**
     * 辐射制冷结构类型
     */
    private Integer type;

    /**
     * 基底材料
     */
    private String bottomMaterail;

    /**
     * 奇数层材料
     */
    private String firstMaterail;

    /**
     * 偶数层材料
     */
    private String secondMetarail;

    /**
     * 数据来源
     */
    private Integer dataFrom;

    /**
     * 入射光类型
     */
    private Integer lightType;

    /**
     * 入射角
     */
    private Float lightAngle;

    /**
     * 工作方式
     */
    private Integer workingMode;

    /**
     * 吸收率表格
     */
    private MultipartFile abs;

    /**
     * 结构数据表格
     */
    private MultipartFile layers;

    /**
     * 程序
     */
    private MultipartFile process;

    /**
     * 保存数据
     */
    private Boolean saveData;

    public CoolingMetatailImportDto() {
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBottomMaterail() {
        return bottomMaterail;
    }

    public void setBottomMaterail(String bottomMaterail) {
        this.bottomMaterail = bottomMaterail;
    }

    public String getFirstMaterail() {
        return firstMaterail;
    }

    public void setFirstMaterail(String firstMaterail) {
        this.firstMaterail = firstMaterail;
    }

    public String getSecondMetarail() {
        return secondMetarail;
    }

    public void setSecondMetarail(String secondMetarail) {
        this.secondMetarail = secondMetarail;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getWorkingMode() {
        return workingMode;
    }

    public void setWorkingMode(Integer workingMode) {
        this.workingMode = workingMode;
    }

    public MultipartFile getAbs() {
        return abs;
    }

    public void setAbs(MultipartFile abs) {
        this.abs = abs;
    }

    public MultipartFile getLayers() {
        return layers;
    }

    public void setLayers(MultipartFile layers) {
        this.layers = layers;
    }

    public MultipartFile getProcess() {
        return process;
    }

    public void setProcess(MultipartFile process) {
        this.process = process;
    }

    public Boolean getSaveData() {
        return saveData;
    }

    public void setSaveData(Boolean saveData) {
        this.saveData = saveData;
    }
}
