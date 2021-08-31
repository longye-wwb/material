package com.crledu.auto.material.photon.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: Trevor
 * @Date: 2020/7/10 10:00
 * @Description:
 */
@TableName(value = "at_photon")
public class Photon {

    private Long id;                //主键id
    private Double n;               //吸收频带数
    private Double fmin1;           //吸收频带1的起始频率
    private Double fmax1;           //吸收频带1的最大频率
    private Double fc1;             //吸收频带1的中心频率 fmax1-fmin1
    private Double fmin2;           //吸收频带2的起始频率
    private Double fmax2;           //吸收频带2的最大频率
    private Double fc2;             //吸收频带2的中心频率 fmax2-fmin2
    private Double fmin3;           //吸收频带3的起始频率
    private Double fmax3;           //吸收频带2的最大频率
    private Double fc3;             //吸收频带3的中心频率 fmax3-fmin3
    private Double db;              //dB形式的吸收率阈值Γ（默认10）
    private Double fDelta;          //频率带宽：几个频段吸收带宽求和Δf  fmax1-fmin1+fmax2-fmin2+fmax3-fmin3
    private Double lambdaDelta;     //波长带宽Δλ  c/fmin1-c/fmax2+c/fmin2-c/fmax2+c/fmin3-c/fmax3
    private Double d;               //厚度d（mm)
    private Double rozanov;         //Rozanov参数Roz：172*d/(Δλ*Γ)
    private Double angle;           //入射角度
    private String polarization;    //偏振
    private String direction;
    private String article;         //文章

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getN() {
        return n;
    }

    public void setN(Double n) {
        this.n = n;
    }

    public Double getFmin1() {
        return fmin1;
    }

    public void setFmin1(Double fmin1) {
        this.fmin1 = fmin1;
    }

    public Double getFmax1() {
        return fmax1;
    }

    public void setFmax1(Double fmax1) {
        this.fmax1 = fmax1;
    }

    public Double getFc1() {
        return fc1;
    }

    public void setFc1(Double fc1) {
        this.fc1 = fc1;
    }

    public Double getFmin2() {
        return fmin2;
    }

    public void setFmin2(Double fmin2) {
        this.fmin2 = fmin2;
    }

    public Double getFmax2() {
        return fmax2;
    }

    public void setFmax2(Double fmax2) {
        this.fmax2 = fmax2;
    }

    public Double getFc2() {
        return fc2;
    }

    public void setFc2(Double fc2) {
        this.fc2 = fc2;
    }

    public Double getFmin3() {
        return fmin3;
    }

    public void setFmin3(Double fmin3) {
        this.fmin3 = fmin3;
    }

    public Double getFmax3() {
        return fmax3;
    }

    public void setFmax3(Double fmax3) {
        this.fmax3 = fmax3;
    }

    public Double getFc3() {
        return fc3;
    }

    public void setFc3(Double fc3) {
        this.fc3 = fc3;
    }

    public Double getDb() {
        return db;
    }

    public void setDb(Double db) {
        this.db = db;
    }

    public Double getfDelta() {
        return fDelta;
    }

    public void setfDelta(Double fDelta) {
        this.fDelta = fDelta;
    }

    public Double getLambdaDelta() {
        return lambdaDelta;
    }

    public void setLambdaDelta(Double lambdaDelta) {
        this.lambdaDelta = lambdaDelta;
    }

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }

    public Double getRozanov() {
        return rozanov;
    }

    public void setRozanov(Double rozanov) {
        this.rozanov = rozanov;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public String getPolarization() {
        return polarization;
    }

    public void setPolarization(String polarization) {
        this.polarization = polarization;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
