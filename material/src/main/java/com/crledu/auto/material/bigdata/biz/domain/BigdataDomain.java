package com.crledu.auto.material.bigdata.biz.domain;

/**
 ************************************************************
 * @Description: 需要文件进行保存的业务数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/18 13:56
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class BigdataDomain {

    /**
     * 对应的导入记录
     */
    private Long importId;

    /**
     * 需要保存的样本数据
     */
    private Object data;

    /**
     * 文件保存地址
     */
    private String path;

    protected BigdataDomain(Long importId, Object data) {
       this.importId = importId;
       this.data = data;
    }

    public static BigdataDomain getInstance(Long importId, Object data){
        return new BigdataDomain(importId, data);
    }

    public Object getData() {
        return data;
    }

    public Long getImportId() {
        return importId;
    }

    public String getPath() {
        return path;
    }

    public void save(String path){
        this.path = path;
    }
}
