package com.crledu.auto.code.config;

/**
 ************************************************************
 * @Description: 功能表单配置
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/2/5 16:36
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class BasePackageConfig {

    /**
     * 生成文件目录
     */
    private String dir;

    /**
     * 包名公共部分
     */
    private String base;

    /**
     * 功能模块
     */
    private String model;

    public BasePackageConfig() {
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
