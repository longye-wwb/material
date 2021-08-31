package com.crledu.auto.material.cooling.biz.dto;

import java.io.File;

/**
 ************************************************************
 * @Description: 辐射制冷导入数据体创建参数
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/16 14:15
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class CoolingMaterialImportCreateDto {

    /**
     * 导入历史主键
     */
    private Long historyId;

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
    private File abs;

    /**
     * 结构数据表格
     */
    private File layers;

    /**
     * 程序
     */
    private File process;

    public CoolingMaterialImportCreateDto() {
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

    public File getAbs() {
        return abs;
    }

    public void setAbs(File abs) {
        this.abs = abs;
    }

    public File getLayers() {
        return layers;
    }

    public void setLayers(File layers) {
        this.layers = layers;
    }

    public File getProcess() {
        return process;
    }

    public void setProcess(File process) {
        this.process = process;
    }

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }
}
