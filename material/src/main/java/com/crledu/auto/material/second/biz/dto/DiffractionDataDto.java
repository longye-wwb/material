package com.crledu.auto.material.second.biz.dto;

/**
 ************************************************************
 * @Description: 衍射组件数据格式
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/13 9:49
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class DiffractionDataDto {

    private float position;
    private float value;

    public DiffractionDataDto() {
    }

    public float getPosition() {
        return position;
    }

    public void setPosition(float position) {
        this.position = position;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
