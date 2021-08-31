package com.crledu.auto.material.impor.biz.dto;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 ************************************************************
 * @Description: 导入数据基础信息
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/20 9:55
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ImportDataItemDto {

    private Long id;

    /**
     * 数据类型 1、吸波材料；2、纳米天线；3、辐射制冷；4、红外兼容；
     */
    private Integer type;

    /**
     * 表单填写数据
     */
    private Map<String,Object> form;

    /**
     * 导入文集序列
     */
    private Map<String, File> files;

    /**
     * 备用的导入数据
     */
    private List<String[]> structData;

    /**
     * 导入时间
     */
    private Date createTime;

    /**
     * 导入人
     */
    private Long creator;

    /**
     * 数据来源
     */
    private Integer dataFrom;

    /**
     * 模拟数据程序
     */
    private File process;

    /**
     * 导入数据状态
     */
    private Integer status;

    public ImportDataItemDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Map<String, Object> getForm() {
        return form;
    }

    public void setForm(Map<String, Object> form) {
        this.form = form;
    }

    public Map<String, File> getFiles() {
        return files;
    }

    public void setFiles(Map<String, File> files) {
        this.files = files;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public File getProcess() {
        return process;
    }

    public void setProcess(File process) {
        this.process = process;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<String[]> getStructData() {
        return structData;
    }

    public void setStructData(List<String[]> structData) {
        this.structData = structData;
    }
}
