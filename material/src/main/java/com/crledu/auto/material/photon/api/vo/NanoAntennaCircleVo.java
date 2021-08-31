package com.crledu.auto.material.photon.api.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * ***********************************************************
 *
 * @Description: 天线导出vo
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/9/7
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class NanoAntennaCircleVo {

    @ExcelProperty(value = "纳米天线结构类型")
    private String topType;

    @ExcelProperty(value = "纳米天线材料")
    private Double topConstant;

    @ExcelProperty(value = "天线高度")
    private Double minH;

    @ExcelProperty(value = "天线半径")
    private Double r;

    @ExcelProperty(value = "基底结构类型")
    private String downType;

    @ExcelProperty(value = "基底材料")
    private Double downConstant;

    @ExcelProperty(value = "基底高度")
    private Double h;

    @ExcelProperty(value = "基底边长")
    private Double p;


    @ExcelProperty(value = "数据来源")
    private String source;

    @ExcelProperty(value = "入射光源类型")
    private String lightType;

    @ExcelProperty(value = "入射角")
    private Double lightAngle;

    @ExcelProperty(value ="工作方式")
    private String workType;

    @ExcelProperty(value = "起始波段")
    private Double start;

    @ExcelProperty(value = "结束波段")
    private Double end;

    @ExcelProperty(value = "相位分布")
    private Double amplitude;

    @ExcelProperty(value = "振幅分布")
    private Double phase;





}
