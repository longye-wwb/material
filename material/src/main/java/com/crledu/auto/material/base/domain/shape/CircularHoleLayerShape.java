package com.crledu.auto.material.base.domain.shape;

/**
 ************************************************************
 * @Description: 圆孔
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/30 11:54
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class CircularHoleLayerShape extends AbstractLayerShape{

    /**
     * 半径
     */
    private Float radius;

    /**
     * 高度
     */
    private Float height;

    @Override
    public Integer getShopId() {
        return 2;
    }
}
