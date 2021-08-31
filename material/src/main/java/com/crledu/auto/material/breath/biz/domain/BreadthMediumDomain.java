package com.crledu.auto.material.breath.biz.domain;

/**
 * ***********************************************************
 *
 * @Description: 介质
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/2
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class BreadthMediumDomain {

    //材料
    private String material;
    //介电常数
    private Float dielectric;
    //损耗正切
    private Float loss;
    //厚度t2
    private Float thickness;

    public String getMaterial() {
        return material;
    }

    public Float getDielectric() {
        return dielectric;
    }

    public Float getLoss() {
        return loss;
    }

    public Float getThickness() {
        return thickness;
    }




    public BreadthMediumDomain (String material,Float dielectric,Float loss,Float thickness){
        this.material=material;
        this.dielectric=dielectric;
        this.loss=loss;
        this.thickness=thickness;
    }
}
