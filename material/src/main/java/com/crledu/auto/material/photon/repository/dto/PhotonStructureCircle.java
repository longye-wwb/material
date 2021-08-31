package com.crledu.auto.material.photon.repository.dto;


import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;

/**
     *****************************************************************************
     * @Description  结构
     *****************************************************************************
     * @Param
     * @return
     *****************************************************************************
     * @Author zjs
     * @Date 2020/9/1 17:27
     *****************************************************************************
     **/
public class PhotonStructureCircle extends BasePhotonstructure {

    @ApiModelProperty(value = "天线半径")
    @ExcelProperty(value = "天线半径")
    private Double r;


    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

}

