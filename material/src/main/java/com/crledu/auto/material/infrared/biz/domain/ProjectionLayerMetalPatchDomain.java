package com.crledu.auto.material.infrared.biz.domain;

import com.crledu.auto.web.exception.RestRuntimeException;

/**
 ************************************************************
 * @Description: 红外反射微波金属贴片层
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 10:40
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ProjectionLayerMetalPatchDomain {

    /**
     * 材料
     */
    private String material;

    /**
     * 红外发射率
     */
    private Float infraredEmissivity;

    /**
     * 周期
     */
    private Float period;

    /**
     * 贴片宽度
     */
    private Float wide;

    /**
     * 金属贴片厚度
     */
    private Float thickness;

    /**
     * 金属占比
     */
    private Float proportionOfMetals;

    protected ProjectionLayerMetalPatchDomain(String material, Float infraredEmissivity, Float period, Float wide) {
        if(material == null||material.isEmpty()){
            throw new RestRuntimeException("透射贴片缺少材料参数","1100000001");
        }
        this.material = material;
        if(infraredEmissivity == null){
            throw new RestRuntimeException("透射贴片缺少红外发射率参数","1100000001");
        }
        this.infraredEmissivity = infraredEmissivity;
        if(period == null){
            throw new RestRuntimeException("透射贴片缺少周期参数","1100000001");
        }
        this.period = period;

        if(wide == null){
            throw new RestRuntimeException("透射贴片缺少宽度参数","1100000001");
        }
        this.wide = wide;
        this.proportionOfMetals = computeProportionOfMetals(period, wide);
    }

    protected ProjectionLayerMetalPatchDomain(String material, Float infraredEmissivity, Float period, Float wide,Float thickness) {
        if(material == null||material.isEmpty()){
            throw new RestRuntimeException("透射贴片缺少材料参数","1100000001");
        }
        this.material = material;
        if(infraredEmissivity == null){
            throw new RestRuntimeException("透射贴片缺少红外发射率参数","1100000001");
        }
        this.infraredEmissivity = infraredEmissivity;
        if(period == null){
            throw new RestRuntimeException("透射贴片缺少周期参数","1100000001");
        }
        this.period = period;

        if(wide == null){
            throw new RestRuntimeException("透射贴片缺少宽度参数","1100000001");
        }
        this.wide = wide;
        this.thickness = thickness;
        this.proportionOfMetals = computeProportionOfMetals(period, wide);
    }

    private Float computeProportionOfMetals(Float period, Float wide){
        Float periodSquare = period * period;
        Float wideSquare = wide * wide;
        return wideSquare/periodSquare;
    }

    public static ProjectionLayerMetalPatchDomain getInstance(String material, Float infraredEmissivity, Float period, Float wide){
        return new ProjectionLayerMetalPatchDomain(material, infraredEmissivity, period, wide);
    }

    public static ProjectionLayerMetalPatchDomain getInstance(String material, Float infraredEmissivity, Float period, Float wide,Float thickness){
        return new ProjectionLayerMetalPatchDomain(material, infraredEmissivity, period, wide,thickness);
    }

    public String getMaterial() {
        return material;
    }

    public Float getInfraredEmissivity() {
        return infraredEmissivity;
    }

    public Float getPeriod() {
        return period;
    }

    public Float getWide() {
        return wide;
    }

    public Float getProportionOfMetals() {
        return proportionOfMetals;
    }
}
