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
 * @Date: 2020/11/25
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class NanoAntennaLayerDomain {

    private Double fake;
    //实部数据
    private Double truth;
    //相位
    private Double phase;
    //振幅
    private Double amplitude;

    //频率
    private Double frequncy;

    private Double waveLength;


    public Double getFake() {
        return fake;
    }

    public Double getTruth() {
        return truth;
    }

    public Double getPhase() {
        return phase;
    }

    public Double getAmplitude() {
        return amplitude;
    }

    public Double getFrequncy() {
        return frequncy;
    }

    public Double getWaveLength() {
        return waveLength;
    }

    public static NanoAntennaLayerDomain getInstance(Double fake,Double truth,Double frequncy){
        return new NanoAntennaLayerDomain(fake,truth,frequncy);
    }

    protected NanoAntennaLayerDomain(Double fake,Double truth,Double frequncy){

        this.fake=fake;
        this.truth=truth;
        this.frequncy=frequncy;
        this.amplitude=(DoubleUtil.div(Math.sqrt(DoubleUtil.sum(Math.pow(fake, 2), Math.pow(truth, 2))), 1d, 9));
        Double c =DoubleUtil.sum(DoubleUtil.div(1d, Math.tan(DoubleUtil.div(fake, truth, 9)), 9),180d)%360d;
        if (c>0) {
            this.phase=(DoubleUtil.sub(c,180d));
        }else {
            this.phase=(DoubleUtil.sum(c,180d));
        }
        this.waveLength=(DoubleUtil.div(300000d, frequncy, 4));
    }



}
