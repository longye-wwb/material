package com.crledu.auto.material.cstparse.biz.dto;

import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: Cst文件标识
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 12:10
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class CstHeaderDto {

    private List<String> header;
    private List<String> data;
    private Integer lines;

    public CstHeaderDto() {
        this.header = new ArrayList<>();
        this.data = new ArrayList<>();
    }

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public Integer getLines() {
        return lines;
    }

    public void setLines(Integer lines) {
        this.lines = lines;
    }
}
