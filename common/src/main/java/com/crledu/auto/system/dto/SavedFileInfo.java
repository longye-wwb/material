package com.crledu.auto.system.dto;

import com.crledu.auto.web.repository.AbstractDomain;

/**
 ************************************************************
 * @Description: 文件存储仓库必要的文件信息
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/7 18:06
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class SavedFileInfo extends AbstractDomain<Long> {

    /**
     * 文件保存路径
     */
    protected String path;

    /**
     * 文件访问路径
     */
    protected String url;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
