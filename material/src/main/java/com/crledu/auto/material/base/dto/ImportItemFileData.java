package com.crledu.auto.material.base.dto;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

/**
 ************************************************************
 * @Description: 表单填写数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/30 15:20
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ImportItemFileData {

   private MultipartFile struct;
    private Map<String,MultipartFile> plusMap;
   private Map<String,MultipartFile> dataMap;

    public ImportItemFileData() {
        this.plusMap = new HashedMap();
        this.dataMap = new HashedMap();
    }

    public MultipartFile getStruct() {
        return struct;
    }

    public void setStruct(MultipartFile struct) {
        this.struct = struct;
    }

    public Map<String, MultipartFile> getPlusMap() {
        return plusMap;
    }

    public void setPlusMap(Map<String, MultipartFile> plusMap) {
        this.plusMap = plusMap;
    }

    public Map<String, MultipartFile> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, MultipartFile> dataMap) {
        this.dataMap = dataMap;
    }
}
