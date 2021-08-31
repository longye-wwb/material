package com.crledu.auto.material.impor.biz.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.Map;

/**
 ************************************************************
 * @Description: 导入数据历史创建数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/18 17:43
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ImportDataCreateDto {

    /**
     * 数据类型 1、吸波材料；2、纳米天线；3、辐射制冷；4、红外兼容-微波透射；5、红外兼容-微波吸收,6，红外光栅；
     */
    private Integer type;

    /**
     * 表单填写数据
     */
    private Map<String,Object> form;

    /**
     * 导入文集序列
     */
    private Map<String, MultipartFile> files;

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
    private MultipartFile process;

    public ImportDataCreateDto() {
    }

    public Map<String, Object> getForm() {
        return form;
    }

    public void setForm(Map<String, Object> form) {
        this.form = form;
    }

    public Map<String, MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(Map<String, MultipartFile> files) {
        this.files = files;
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

    public MultipartFile getProcess() {
        return process;
    }

    public void setProcess(MultipartFile process) {
        this.process = process;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
