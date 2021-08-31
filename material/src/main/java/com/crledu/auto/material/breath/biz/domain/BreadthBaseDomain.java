package com.crledu.auto.material.breath.biz.domain;

/**
 * ***********************************************************
 *
 * @Description: 基底
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/2
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class BreadthBaseDomain {

    //材料
    private String material;
    //厚度 t1
    private Float thickness;

    public String getMaterial() {
        return material;
    }

    public Float getThickness() {
        return thickness;
    }

    public BreadthBaseDomain(String material, Float thickness){
        this.material=material;
        this.thickness=thickness;
    }
}
