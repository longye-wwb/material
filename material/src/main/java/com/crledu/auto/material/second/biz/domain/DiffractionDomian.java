package com.crledu.auto.material.second.biz.domain;

import com.crledu.auto.material.base.domain.AbstructImportDomain;
import com.crledu.auto.material.base.service.annotation.ColumnName;
import com.crledu.auto.material.base.service.annotation.DataName;
import com.crledu.auto.material.base.service.annotation.TableConstructor;
import com.crledu.auto.material.second.biz.dto.DiffractionDataDto;
import com.crledu.auto.material.second.biz.dto.DiffractionImportDto;
import com.crledu.auto.web.exception.RestRuntimeException;

import java.util.List;

/**
 ************************************************************
 * @Description: 衍射原件导入数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/12 15:39
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class DiffractionDomian extends AbstructImportDomain {

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

    /**
     * 组件结构图地址
     */
    private String picture;

    /**
     * 衍射效果图
     */
    private float[][] diffraction;




    @TableConstructor
    public DiffractionDomian(@ColumnName("picture")String metlab, DiffractionImportDto importItemFormData, Float[] waveLengths, @DataName("diffraction") String[] diffraction) {
        super(importItemFormData);
        this.picture = metlab;
        this.angle = importItemFormData.getAngle();
        this.BaseRefractive = importItemFormData.getBaseRefractive();
        this.inLine = importItemFormData.getInLine();
        this.order = importItemFormData.getOrder();
        this.period = importItemFormData.getPeriod();
        this.refractive = importItemFormData.getRefractive();
        if(order * order != diffraction.length){
            throw new RestRuntimeException("衍射阶数与数据不对应","14000001");
        }
        //组装衍射测量数据
        this.diffraction = new float[order][order];
        for(int i = 0;i<diffraction.length;i++){
            int row = i/order;
            int col = i%order;
            this.diffraction[row][col] = Float.parseFloat(diffraction[i]);
        }
    }

    public float getInLine() {
        return inLine;
    }

    public float getPeriod() {
        return period;
    }

    public float getRefractive() {
        return refractive;
    }

    public float getBaseRefractive() {
        return BaseRefractive;
    }

    public float getAngle() {
        return angle;
    }

    public int getOrder() {
        return order;
    }

    public String getPicture() {
        return picture;
    }

    public float[][] getDiffraction() {
        return diffraction;
    }
}
