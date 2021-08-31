package com.crledu.auto.material.photon.biz.domain;


import com.crledu.auto.material.photon.repository.util.DoubleUtil;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/11/23
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class AbsorbLayerDomain {


    //起始频率
    private Double start;

    //结束频率
    private Double end;

    //中心频率
    private Double center;

    public Double getStart() {
        return start;
    }

    public Double getEnd() {
        return end;
    }

    public Double getCenter() {
        return center;
    }

    public static AbsorbLayerDomain getInstense(Double start, Double end){

        return new AbsorbLayerDomain(start,end);

    }

    protected AbsorbLayerDomain(Double start, Double end) {
        this.start = start;
        this.end = end;
        this.center= DoubleUtil.div(DoubleUtil.sum(start,end),2,5);
    }
}

