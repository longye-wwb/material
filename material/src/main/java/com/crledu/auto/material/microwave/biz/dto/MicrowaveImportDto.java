package com.crledu.auto.material.microwave.biz.dto;

import com.crledu.auto.material.base.dto.ImportItemFormData;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/10
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class MicrowaveImportDto extends ImportItemFormData {

    //结构材料
    private Integer materialStructure;
    //填充材料
    private Integer filler;
    private Integer lightType;
    private Float lightAngle;
    private Integer workType;

    public Integer getMaterialStructure() {
        return materialStructure;
    }

    public void setMaterialStructure(Integer materialStructure) {
        this.materialStructure = materialStructure;
    }

    public Integer getFiller() {
        return filler;
    }

    public void setFiller(Integer filler) {
        this.filler = filler;
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

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }
}
