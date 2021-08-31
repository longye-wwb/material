package com.crledu.auto.material.infrared.repository.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

/**
 ************************************************************
 * @Description: 微波吸收层数据实体
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/26 17:40
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@TableName("at_microwave_absorbing")
public class MicrowaveAbsorbingLayerEntity {

    @TableId
    private Long id;

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

    /**
     * 吸收率数据
     */
    private String absorbingData;

    /**
     * 数据状态
     */
    private Integer curStatus;


    public MicrowaveAbsorbingLayerEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
