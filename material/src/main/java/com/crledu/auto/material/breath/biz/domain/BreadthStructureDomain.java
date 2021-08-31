package com.crledu.auto.material.breath.biz.domain;

/**
 * ***********************************************************
 *
 * @Description: 微波窄带吸收结构层
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/2
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class BreadthStructureDomain {

    //类型
    private Integer type;
    //材料
    private String material;
    //厚度 d
    private Float thickness;
    //周期 p
    private Float period;
    //外环边长 l
    private Float length;
    //宽度 w
    private Float width;


    public Integer getType() {
        return type;
    }

    public String getMaterial() {
        return material;
    }

    public Float getThickness() {
        return thickness;
    }

    public Float getPeriod() {
        return period;
    }

    public Float getLength() {
        return length;
    }

    public Float getWidth() {
        return width;
    }



    public BreadthStructureDomain (Integer type,String material,Float thickness,Float period,Float length,Float width){
        this.type=type;
        this.material=material;
        this.period=period;
        this.thickness=thickness;
        this.length=length;
        this.width=width;
    }
}
