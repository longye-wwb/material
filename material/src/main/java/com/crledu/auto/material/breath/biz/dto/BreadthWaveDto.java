package com.crledu.auto.material.breath.biz.dto;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/7
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class BreadthWaveDto {

    private Float wavelenth;

    private Float data;

    public Float getWavelenth() {
        return wavelenth;
    }

    public Float getData() {
        return data;
    }


    public BreadthWaveDto(Float wavelenth, Float data){
        this.wavelenth=wavelenth;
        this.data=data;
    }
}
