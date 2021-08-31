package com.crledu.auto.material.impor.biz.domain;

import com.crledu.auto.util.ObjectUtils;

import java.io.File;
import java.util.Date;
import java.util.Map;

/**
 ************************************************************
 * @Description: 广电数据导入业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/11 17:55
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ImportDataDomain {

    public static final Integer ABSORBING_WAVE_MATERIAL_TYPE = 1;
    public static final Integer NANO_ANTENNA_MATERIAL_TYPE = 2;
    public static final String[] ABSORBING_WAVE_MATERIAL_TABLE = {"at_photon","at_sky_new"};
    public static final Integer INFRARED_GRATING=6;
    public static final Integer INFRARED_PROJECTION = 7;
    public static final Integer BREADTH=8;

    public static final Integer MICRON_ANTENNA_TYPE = 9;
    public static final Integer INFRARED_AMPLITUDE_ANTENNA_TYPE = 10;
    public static final Integer INFRARED_PHASE_ANTENNA_TYPE = 11;
    public static final Integer MICROWAVE_AMPLITUDE_TYPE = 12;
    public static final Integer MICROWAVE_PHASE_TYPE = 14;

    /**
     * 导入数据主键
     */
    private Long id;

    /**
     * 数据类型 1、吸波材料；2、纳米天线；3、辐射制冷；4、红外兼容；
     */
    private Integer type;

    /**
     * 表单填写数据
     */
    private Map<String,Object> form;

    /**
     * 导入文集序列
     */
    private Map<String, File> files;

    /**
     * 导入时间
     */
    private Date createTime;

    /**
     * 导入人
     */
    private Long creator;

    /**
     * 数据来源
     */
    private Integer dataFrom;

    /**
     * 模拟数据程序
     */
    private File process;

    /**
     * 导入数据状态
     */
    private Integer status;

    /**
     * 数据文件大小
     */
    private Float dataSize;

    public ImportDataDomain(Long id, Integer type, Map<String, Object> form, Map<String, File> files, Date createTime, Long creator, Integer dataFrom, File process, Integer status, Float dataSize) {
        this.id = id;
        this.type = type;
        this.form = form;
        this.files = files;
        this.createTime = createTime;
        this.creator = creator;
        this.dataFrom = dataFrom;
        this.process = process;
        this.status = status;
        this.dataSize = dataSize;
    }

    protected ImportDataDomain(Integer type, Map<String, Object> form, Map<String, File> files, Long creator, Integer dataFrom, File process) {
        this.createTime = new Date();
        this.type = type;
        this.form = form;
        this.files = files;
        this.creator = creator;
        this.dataFrom = dataFrom;
        this.process = process;
        this.status = 1;
        this.dataSize = 0f;
    }

    public void addDataSize(Float size){
        if(ObjectUtils.isNotNull(this.dataSize)){
            this.dataSize += size;
        }else{
            this.dataSize = size;
        }
    }

    public static ImportDataDomain getInstance(Integer type, Map<String, Object> form, Map<String, File> files, Long creator, Integer dataFrom, File process){
        return new ImportDataDomain(type, form, files, creator, dataFrom, process);
    }

    public Long getId() {
        return id;
    }

    public Map<String, Object> getForm() {
        return form;
    }

    public Map<String, File> getFiles() {
        return files;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Long getCreator() {
        return creator;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public File getProcess() {
        return process;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getType() {
        return type;
    }

    public Float getDataSize() {
        return dataSize;
    }
}
