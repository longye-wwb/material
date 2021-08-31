package com.crledu.auto.material.infrared.biz.domain;

import com.crledu.auto.material.infrared.biz.dto.ProjectionDataItemDto;

import java.util.List;

/**
 ************************************************************
 * @Description: 红外反射微波透射导入数据业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 16:40
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ProjectionLayerImportDataDomain {

    private String[] struct;
    private String[] structHeader;
    private String[] waveArray;
    private String[] data;

    private Float lightAngle;
    private Integer dataFrom;

    private ProjectionLayerDomain projectionLayerDomain;
    private List<ProjectionDataItemDto> dataList;

    protected ProjectionLayerImportDataDomain(String[] struct, String[] structHeader, String[] waveArray, String[] data, Float lightAngle, Integer dataFrom) {
        this.struct = struct;
        this.structHeader = structHeader;
        this.waveArray = waveArray;
        this.data = data;
        this.lightAngle = lightAngle;
        this.dataFrom = dataFrom;
    }

    public static  ProjectionLayerImportDataDomain getInstance(String[] struct, String[] structHeader, String[] waveArray, String[] data, Float lightAngle, Integer dataFrom){
        return new ProjectionLayerImportDataDomain(struct, structHeader, waveArray, data, lightAngle, dataFrom);
    }

    public ProjectionLayerDomain getProjectionLayerDomain() {
        return projectionLayerDomain;
    }

    public List<ProjectionDataItemDto> getDataList() {
        return dataList;
    }
}
