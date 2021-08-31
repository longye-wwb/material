package com.crledu.auto.material.photon.repository.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/9/3
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class PhotonSkyModel {

    @ApiModelProperty(value = "纳米天线结构类型")
    private String topType;

    @ApiModelProperty(value = "纳米天线材料")
    private Double topConstant;

    @ApiModelProperty(value = "基底结构类型")
    private String downType;

    @ApiModelProperty(value = "基底材料")
    private Double downConstant;

    @ApiModelProperty(value = "数据来源")
    private String source;

    @ApiModelProperty(value = "入射光源类型")
    private String lightType;

    @ApiModelProperty(value = "入射角")
    private Double lightAngle;

    @ApiModelProperty(value ="工作方式")
    private String workType;

    @ApiModelProperty(value = "基座厚度")
    private Double h;

    @ApiModelProperty(value = "基座边长")
    private Double p;

    @ApiModelProperty(value = "天线高度")
    private Double minH;


    @ApiModelProperty(value = "起始波段")
    private Double start;

    @ApiModelProperty(value = "结束波段")
    private Double end;

    @ApiModelProperty(value = "相位分布")
    private Double amplitude;

    @ApiModelProperty(value = "振幅分布")
    private Double phase;





}
