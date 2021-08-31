package com.crledu.auto.web.vo.number;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("数值类型参数选择")
public abstract class AbstractSelectNumberParamVo<NT> {

    @ApiModelProperty("等于")
    private NT eq;

    @ApiModelProperty("大于")
    private NT gt;

    @ApiModelProperty("小于")
    private NT lt;

    @ApiModelProperty("大于等于")
    private NT gte;

    @ApiModelProperty("小于等于")
    private NT lte;

    public AbstractSelectNumberParamVo() {
    }

    public NT getEq() {
        return eq;
    }

    public void setEq(NT eq) {
        this.eq = eq;
    }

    public NT getGt() {
        return gt;
    }

    public void setGt(NT gt) {
        this.gt = gt;
    }

    public NT getLt() {
        return lt;
    }

    public void setLt(NT lt) {
        this.lt = lt;
    }

    public NT getGte() {
        return gte;
    }

    public void setGte(NT gte) {
        this.gte = gte;
    }

    public NT getLte() {
        return lte;
    }

    public void setLte(NT lte) {
        this.lte = lte;
    }
}
