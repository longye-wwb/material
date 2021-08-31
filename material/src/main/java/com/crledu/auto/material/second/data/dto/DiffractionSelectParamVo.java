package com.crledu.auto.material.second.data.dto;

import com.crledu.auto.web.view.PageParamVO;
import com.crledu.auto.web.vo.number.FloatParamVo;
import com.crledu.auto.web.vo.number.IntegerParamVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 衍射组件列表筛选参数
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/13 10:40
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("衍射组件筛选")
public class DiffractionSelectParamVo extends PageParamVO {

    /**
     * 入射波长
     */
    @ApiModelProperty("入射波长")
    private FloatParamVo inLine;

    /**
     * 材料周期
     */
    @ApiModelProperty("材料周期")
    private FloatParamVo period;

    /**
     * 材料折射率
     */
    @ApiModelProperty("材料折射率")
    private FloatParamVo refractive;

    /**
     * 基底折射率
     */
    @ApiModelProperty("基底折射率")
    private FloatParamVo BaseRefractive;

    /**
     * 衍射角
     */
    @ApiModelProperty("衍射角")
    private FloatParamVo angle;

    /**
     * 衍射阶数
     */
    @ApiModelProperty("衍射阶数")
    private IntegerParamVo order;

    public DiffractionSelectParamVo() {
    }

    public FloatParamVo getInLine() {
        return inLine;
    }

    public void setInLine(FloatParamVo inLine) {
        this.inLine = inLine;
    }

    public FloatParamVo getPeriod() {
        return period;
    }

    public void setPeriod(FloatParamVo period) {
        this.period = period;
    }

    public FloatParamVo getRefractive() {
        return refractive;
    }

    public void setRefractive(FloatParamVo refractive) {
        this.refractive = refractive;
    }

    public FloatParamVo getBaseRefractive() {
        return BaseRefractive;
    }

    public void setBaseRefractive(FloatParamVo baseRefractive) {
        BaseRefractive = baseRefractive;
    }

    public FloatParamVo getAngle() {
        return angle;
    }

    public void setAngle(FloatParamVo angle) {
        this.angle = angle;
    }

    public IntegerParamVo getOrder() {
        return order;
    }

    public void setOrder(IntegerParamVo order) {
        this.order = order;
    }
}
