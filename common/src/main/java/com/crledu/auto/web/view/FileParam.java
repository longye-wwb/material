package com.crledu.auto.web.view;

import io.swagger.annotations.ApiModel;

@ApiModel("文件上传参数")
public class FileParam {

    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件系统标识
     */
    private Long index;

    /**
     * 文件访问路径
     */
    private String url;

    /**
     * 文件状态
     */
    private String status;

    public FileParam() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
