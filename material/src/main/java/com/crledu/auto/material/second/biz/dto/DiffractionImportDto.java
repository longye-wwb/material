package com.crledu.auto.material.second.biz.dto;

import com.crledu.auto.material.base.dto.ImportItemFormData;

/**
 ************************************************************
 * @Description: 衍射组件导入参数
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/12 17:33
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class DiffractionImportDto extends ImportItemFormData {

    /**
     * 入射波长
     */
    private float inLine;

    /**
     * 材料周期
     */
    private float period;

    /**
     * 材料折射率
     */
    private float refractive;

    /**
     * 基底折射率
     */
    private float BaseRefractive;

    /**
     * 衍射角
     */
    private float angle;

    /**
     * 衍射阶数
     */
    private int order;

    public DiffractionImportDto() {
    }

    public float getInLine() {
        return inLine;
    }

    public void setInLine(float inLine) {
        this.inLine = inLine;
    }

    public float getPeriod() {
        return period;
    }

    public void setPeriod(float period) {
        this.period = period;
    }

    public float getRefractive() {
        return refractive;
    }

    public void setRefractive(float refractive) {
        this.refractive = refractive;
    }

    public float getBaseRefractive() {
        return BaseRefractive;
    }

    public void setBaseRefractive(float baseRefractive) {
        BaseRefractive = baseRefractive;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
