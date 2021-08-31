package com.crledu.auto.material.infrared.biz.domain;

/**
 ************************************************************
 * @Description: 微波吸收层薄膜电阻
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 11:20
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class MicrowaveAbsorbingLayerFilmResistanceDomain {

    /**
     * 形状
     */
    private Integer shape;

    /**
     * 边长
     */
    private Float sideLength;

    /**
     * 电阻
     */
    private Float resistance;


    protected MicrowaveAbsorbingLayerFilmResistanceDomain(Integer shape, Float sideLength, Float resistance) {
        this.shape = shape;
        this.sideLength = sideLength;
        this.resistance = resistance;
    }

    public static MicrowaveAbsorbingLayerFilmResistanceDomain getInstance(Integer shape, Float sideLength, Float resistance){
        return new MicrowaveAbsorbingLayerFilmResistanceDomain(shape,sideLength,resistance);
    }

    public Integer getShape() {
        return shape;
    }

    public Float getSideLength() {
        return sideLength;
    }

    public Float getResistance() {
        return resistance;
    }
}
