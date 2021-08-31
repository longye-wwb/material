package com.crledu.auto.material.photon.repository.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/8/25
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class PhotonExport {

    @ApiModelProperty(value = "序号")
    @ExcelProperty(value = "序号")
    private String number;
    @ApiModelProperty(value = "吸收频带数")
    @ExcelProperty(value = "吸收频带数N")
    private Double n;
    @ApiModelProperty(value = "吸收频带1的起始频率")
    @ExcelProperty(value = "fmin1：吸收频带1的起始频率")
    private Double fmin1;
    @ApiModelProperty(value ="吸收频带1的最大频率")
    @ExcelProperty(value = "fmax1：吸收频带1的最大频率")
    private Double fmax1;
    @ApiModelProperty(value = "吸收频带1的中心频率 fmax1-fmin1")
    @ExcelProperty(value = "fc1:吸收频带1的中心频率")
    private Double fc1;
    @ApiModelProperty(value = "吸收频带2的起始频率")
    @ExcelProperty(value = "fmin2：吸收频带2的起始频率")
    private Double fmin2;
    @ApiModelProperty(value = "吸收频带2的最大频率")
    @ExcelProperty(value = "fmax2：吸收频带2的最大频率")
    private Double fmax2;
    @ApiModelProperty(value = "吸收频带2的中心频率 fmax2-fmin2")
    @ExcelProperty(value = "fc2:吸收频带2的中心频率")
    private Double fc2;
    @ApiModelProperty(value = "吸收频带3的起始频率")
    @ExcelProperty(value = "fmin3：吸收频带3的起始频率")
    private Double fmin3;
    @ApiModelProperty(value = "吸收频带2的最大频率")
    @ExcelProperty(value = "fmax3：吸收频带3的最大频率")
    private Double fmax3;
    @ApiModelProperty(value = "吸收频带3的中心频率 fmax3-fmin3")
    @ExcelProperty(value = "fc3:吸收频带3的中心频率")
    private Double fc3;
    @ApiModelProperty(value = "dB形式的吸收率阈值Γ（默认10）")
    @ExcelProperty(value = "dB形式的吸收率阈值Γ（默认10）")
    private Double db;
    @ApiModelProperty(value = "频率带宽：几个频段吸收带宽求和Δf  fmax1-fmin1+fmax2-fmin2+fmax3-fmin3")
    @ExcelProperty(value = "频率带宽")
    private Double fDelta;
    @ApiModelProperty(value = "波长带宽Δλ  c/fmin1-c/fmax2+c/fmin2-c/fmax2+c/fmin3-c/fmax3")
    @ExcelProperty(value = "波长带宽Δλ(mm)")
    private Double lambdaDelta;
    @ApiModelProperty(value = "厚度d（mm)")
    @ExcelProperty(value = "厚度d（mm)")
    private Double d;
    @ApiModelProperty(value = "Rozanov参数Roz：172*d/(Δλ*Γ)")
    @ExcelProperty(value = "Rozanov参数Roz：172*d/(Δλ*Γ)")
    private Double rozanov;
    @ApiModelProperty(value = "入射角度")
    @ExcelProperty(value = "入射角度")
    private Double angle;
    @ApiModelProperty(value = "偏振")
    @ExcelProperty(value = "入射偏振")
    private String polarization;
    @ApiModelProperty(value = "入射方向.正向反向")
    @ExcelProperty(value = "入射方向")
    private String direction;
    @ApiModelProperty(value = "文章地址")
    @ExcelProperty(value = "文章地址")
    private String article;


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


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
