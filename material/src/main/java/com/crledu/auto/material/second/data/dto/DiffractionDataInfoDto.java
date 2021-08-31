package com.crledu.auto.material.second.data.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 衍射组件数据详情
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/13 10:35
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("衍射组件")
public class DiffractionDataInfoDto extends DiffractionDataItemDto{

    @ApiModelProperty("数据文件")
    private String data;
    /**
     * 组件结构图地址
     */
    @ApiModelProperty("结构图")
    private String picture;

    /**
     * 衍射效果图
     */
    @ApiModelProperty("效果图")
    private String diffraction;

    public DiffractionDataInfoDto() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDiffraction() {
        return diffraction;
    }

    public void setDiffraction(String diffraction) {
        this.diffraction = diffraction;
    }
}
