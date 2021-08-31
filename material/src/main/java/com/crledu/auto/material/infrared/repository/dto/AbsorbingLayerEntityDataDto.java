package com.crledu.auto.material.infrared.repository.dto;

import java.util.List;

/**
 ************************************************************
 * @Description: 保存单条材料数据到文件结构
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/27 10:18
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class AbsorbingLayerEntityDataDto {

    /**
     * 导入历史主键
     */
    private Long importId;

    /**
     * 透射层周期
     */
    private Float period;

    /**
     * 数据来源
     */
    private Integer dataFrom;

    /**
     * 入射角
     */
    private Float lightAngle;

    private List<AbsorbingLayerItemEntityDataDto> layers;

    /**
     * 吸收率数据
     */
    private String absorbingData;

    /**
     * 数据状态
     */
    private Integer curStatus;

    public AbsorbingLayerEntityDataDto() {
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public Float getPeriod() {
        return period;
    }

    public void setPeriod(Float period) {
        this.period = period;
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

    public String getAbsorbingData() {
        return absorbingData;
    }

    public void setAbsorbingData(String absorbingData) {
        this.absorbingData = absorbingData;
    }

    public Integer getCurStatus() {
        return curStatus;
    }

    public void setCurStatus(Integer curStatus) {
        this.curStatus = curStatus;
    }

    public List<AbsorbingLayerItemEntityDataDto> getLayers() {
        return layers;
    }

    public void setLayers(List<AbsorbingLayerItemEntityDataDto> layers) {
        this.layers = layers;
    }
}
