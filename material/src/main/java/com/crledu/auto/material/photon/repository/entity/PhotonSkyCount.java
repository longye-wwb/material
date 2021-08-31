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
 * @Date: 2020/9/3
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
@TableName(value = "at_sky_count")
public class PhotonSkyCount {

    private Long id;
    private Double phase;
    private Double amplitude;
    private Double fake;
    private Double truth;
    private Long skyType;
    private Double start;
    private Double end;
    private Long skyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPhase() {
        return phase;
    }

    public void setPhase(Double phase) {
        this.phase = phase;
    }

    public Double getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(Double amplitude) {
        this.amplitude = amplitude;
    }

    public Double getFake() {
        return fake;
    }

    public void setFake(Double fake) {
        this.fake = fake;
    }

    public Double getTruth() {
        return truth;
    }

    public void setTruth(Double truth) {
        this.truth = truth;
    }

    public Long getSkyType() {
        return skyType;
    }

    public void setSkyType(Long skyType) {
        this.skyType = skyType;
    }

    public Double getStart() {
        return start;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getEnd() {
        return end;
    }

    public void setEnd(Double end) {
        this.end = end;
    }

    public Long getSkyId() {
        return skyId;
    }

    public void setSkyId(Long skyId) {
        this.skyId = skyId;
    }
}
