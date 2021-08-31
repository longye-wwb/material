package com.crledu.auto.material.base.domain.shape;

/**
 ************************************************************
 * @Description: 椭圆柱
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/30 12:05
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class EllipticCylinderLayerShape extends AbstractLayerShape {

    /**
     * 长轴
     */
    private Float majorAxis;

    /**
     * 短轴
     */
    private Float minorAxis;

    /**
     * 高度
     */
    private Float height;

    /**
     * 面内旋转角
     */
    private Float planeAngle;

    @Override
    public Integer getShopId() {
        return 5;
    }
}
