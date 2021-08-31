package com.crledu.auto.material.photon.repository.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/9/1
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class BasePhotonstructure {

    @ApiModelProperty(value = "基座厚度")
    @ExcelProperty(value = "基座厚度")
    private Double h;

    @ApiModelProperty(value = "基座边长")
    @ExcelProperty(value = "基座边长")
    private Double p;

    @ApiModelProperty(value = "天线高度")
    @ExcelProperty(value = "天线高度")
    private Double minH;

    public Double getH() {
        return h;
    }

    public void setH(Double h) {
        this.h = h;
    }

    public Double getP() {
        return p;
    }

    public void setP(Double p) {
        this.p = p;
    }

    public Double getMinH() {
        return minH;
    }

    public void setMinH(Double minH) {
        this.minH = minH;
    }
}
