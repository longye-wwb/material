package com.crledu.auto.material.base.domain;

import com.crledu.auto.material.base.dto.ImportItemFormData;

import java.io.File;

/**
 ************************************************************
 * @Description: 导入数据的具体单元
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/30 15:01
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public abstract class AbstructImportDomain {

    private Long importId;
    private Integer dataFrom;
    private Boolean saveData;

    public AbstructImportDomain(ImportItemFormData importItemFormData) {
        this.dataFrom = importItemFormData.getDataFrom();
        this.importId = importItemFormData.getImportId();
        this.saveData = importItemFormData.getSaveData();
    }

    public Long getImportId() {
        return importId;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public Boolean getSaveData() {
        return saveData;
    }
}
