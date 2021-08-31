package com.crledu.auto.material.base.domain.shape;

/**
 ************************************************************
 * @Description: 方形
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/30 11:48
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class SquareLayerShape extends AbstractLayerShape {
    /**
     * 边长
     */
    private Float side;

    @Override
    public Integer getShopId() {
        return 1;
    }
}
