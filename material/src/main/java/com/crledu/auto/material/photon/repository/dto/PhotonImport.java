package com.crledu.auto.material.photon.repository.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import sun.misc.Cache;

/**
 * @Author: Trevor
 * @Date: 2020/7/10 10:51
 * @Description:
 */
public class PhotonImport {


    @ApiModelProperty(value = "吸收频带数")
    @ExcelProperty(value = "吸收频带数N")
    private Double n;
    @ApiModelProperty(value = "吸收频带1的起始频率")
    @ExcelProperty(value = "fmin1：吸收频带1的起始频率")
    private Double fmin1;
    @ApiModelProperty(value ="吸收频带1的最大频率")
    @ExcelProperty(value = "fmax1：吸收频带1的最大频率")
    private Double fmax1;
    @ApiModelProperty(value = "吸收频带2的起始频率")
   @ExcelProperty(value = "fmin2：吸收频带2的起始频率")
    private Double fmin2;
    @ApiModelProperty(value = "吸收频带2的最大频率")
    @ExcelProperty(value = "fmax2：吸收频带2的最大频率")
    private Double fmax2;
    @ApiModelProperty(value = "吸收频带3的起始频率")
    @ExcelProperty(value = "fmin3：吸收频带3的起始频率")
    private Double fmin3;
    @ApiModelProperty(value = "吸收频带2的最大频率")
    @ExcelProperty(value = "fmax3：吸收频带3的最大频率")
    private Double fmax3;
    @ApiModelProperty(value = "dB形式的吸收率阈值Γ（默认10）")
    @ExcelProperty(value = "dB形式的吸收率阈值Γ（默认10）")
    private Double db;
    @ApiModelProperty(value = "厚度d（mm)")
    @ExcelProperty(value = "厚度d（mm)")
    private Double d;
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
    @ApiModelProperty(value = "附件地址")
    @ExcelProperty(value = "附件地址")
    private String appendix;

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


    public Double getDb() {
        return db;
    }

    public void setDb(Double db) {
        this.db = db;
    }


    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
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

    public String getAppendix() {
        return appendix;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }
}
