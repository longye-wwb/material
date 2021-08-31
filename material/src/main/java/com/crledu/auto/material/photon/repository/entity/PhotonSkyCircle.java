package com.crledu.auto.material.photon.repository.entity;


import com.baomidou.mybatisplus.annotation.TableName;


/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/9/2
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
@TableName(value = "at_sky_circle")
public class PhotonSkyCircle {

    private Double h;

    private Double p;


    private Double minH;

    private Double r;

    private Long skyId;

    public Double getH() {
        return h;
    }

    public void setH(Double h) {
        this.h = h;
    }

    public Double getP() {
        return p;
    }

    public void setP(Double p) {
        this.p = p;
    }

    public Double getMinH() {
        return minH;
    }

    public void setMinH(Double minH) {
        this.minH = minH;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public Long getSkyId() {
        return skyId;
    }

    public void setSkyId(Long skyId) {
        this.skyId = skyId;
    }
}
