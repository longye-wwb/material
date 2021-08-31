package com.crledu.auto.excel.dto;

import java.util.List;

/**
 ************************************************************
 * @Description: excel文件表头设置
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/4/12 16:23
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ExcelSettings {

    public static final int DEFAULT_BEGIN_ROW = 2;

    /**
     * 表格名称
     */
    private String name;

    /**
     * 制表日期
     */
    private String date;

    /**
     * 数据开始行号
     */
    private Integer beginData;

    /**
     * 数据列相关数据
     */
    private List<ColumnSettings> columnSettings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getBeginData() {
        return beginData;
    }

    public void setBeginData(Integer beginData) {
        this.beginData = beginData;
    }

    public List<ColumnSettings> getColumnSettings() {
        return columnSettings;
    }

    public void setColumnSettings(List<ColumnSettings> columnSettings) {
        this.columnSettings = columnSettings;
    }
}
