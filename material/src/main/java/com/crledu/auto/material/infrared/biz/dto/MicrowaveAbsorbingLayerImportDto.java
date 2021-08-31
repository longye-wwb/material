package com.crledu.auto.material.infrared.biz.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 ************************************************************
 * @Description: 微波吸收功能层导入数据DTO
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/25 16:06
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class MicrowaveAbsorbingLayerImportDto {

    /**
     * 主键
     */
    private Long id;

    /**
     * 导入用户
     */
    private Long creator;

    /**
     * 结构相关参数
     */
    private MultipartFile struct;

    /**
     * 吸收数据
     */
    private MultipartFile data;

    /**
     * 模拟程序文件
     */
    private MultipartFile process;

    /**
     * 周期
     */
    private Float period;

    /**
     * 组成层结构
     */
    private List<MicrowaveAbsorbingItemLayerDto> layerItemVos;

    /**
     * 数据来源
     */
    private Integer dataFrom;

    /**
     * 入射角
     */
    private Float lightAngle;

    /**
     * 保存数据
     */
    private Boolean saveInData;

    public MicrowaveAbsorbingLayerImportDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public MultipartFile getStruct() {
        return struct;
    }

    public void setStruct(MultipartFile struct) {
        this.struct = struct;
    }

    public MultipartFile getData() {
        return data;
    }

    public void setData(MultipartFile data) {
        this.data = data;
    }

    public MultipartFile getProcess() {
        return process;
    }

    public void setProcess(MultipartFile process) {
        this.process = process;
    }

    public Float getPeriod() {
        return period;
    }

    public void setPeriod(Float period) {
        this.period = period;
    }

    public List<MicrowaveAbsorbingItemLayerDto> getLayerItemVos() {
        return layerItemVos;
    }

    public void setLayerItemVos(List<MicrowaveAbsorbingItemLayerDto> layerItemVos) {
        this.layerItemVos = layerItemVos;
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

    public Boolean getSaveInData() {
        return saveInData;
    }

    public void setSaveInData(Boolean saveInData) {
        this.saveInData = saveInData;
    }
}
