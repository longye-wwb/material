package com.crledu.auto.material.base.dto;

/**
 ************************************************************
 * @Description: 导入的表单参数
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/2 9:53
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ImportItemFormData {
    private Integer dataFrom;
    private Long importId;
    private Boolean saveData;

    public ImportItemFormData() {
        saveData = true;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public Boolean getSaveData() {
        return saveData;
    }

    public void setSaveData(Boolean saveData) {
        this.saveData = saveData;
    }
}
