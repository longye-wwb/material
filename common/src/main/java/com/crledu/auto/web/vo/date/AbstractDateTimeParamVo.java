package com.crledu.auto.web.vo.date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 时间筛选参数格式
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/11 11:54
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("时间筛选参数格式")
public abstract class AbstractDateTimeParamVo<TYPE> {

    @ApiModelProperty("在此之前")
    private TYPE before;

    @ApiModelProperty("在此之后")
    private TYPE after;

    @ApiModelProperty("同一时间")
    private TYPE sameTime;

    public AbstractDateTimeParamVo() {
    }

    public TYPE getBefore() {
        return before;
    }

    public void setBefore(TYPE before) {
        this.before = before;
    }

    public TYPE getAfter() {
        return after;
    }

    public void setAfter(TYPE after) {
        this.after = after;
    }

    public TYPE getSameTime() {
        return sameTime;
    }

    public void setSameTime(TYPE sameTime) {
        this.sameTime = sameTime;
    }
}
