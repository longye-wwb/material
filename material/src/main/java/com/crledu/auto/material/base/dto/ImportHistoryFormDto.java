package com.crledu.auto.material.base.dto;

import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import org.springframework.web.multipart.MultipartFile;

/**
 ************************************************************
 * @Description: 导入历史数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/2 9:36
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ImportHistoryFormDto {

    /**
     * 导入主键
     */
    private Long importId;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 模拟程序
     */
    private MultipartFile process;

    /**
     * 数据来源
     */
    private Integer dataForm;

    /**
     * 数据类型
     */
    private DataTypeEnum type;

    public ImportHistoryFormDto() {
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

    public MultipartFile getProcess() {
        return process;
    }

    public void setProcess(MultipartFile process) {
        this.process = process;
    }

    public Integer getDataForm() {
        return dataForm;
    }

    public void setDataForm(Integer dataForm) {
        this.dataForm = dataForm;
    }

    public DataTypeEnum getType() {
        return type;
    }

    public void setType(DataTypeEnum type) {
        this.type = type;
    }
}
