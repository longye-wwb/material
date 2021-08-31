package com.crledu.auto.code.config;

/**
 ************************************************************
 * @Description: 项目配置
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/2/5 17:06
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ProjectConfig {

    /**
     * 文件地址
     */
    private String dir;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 甲方名称
     */
    private String author;

    /**
     * 联系邮箱
     */
    private String email;

    /**
     * 系统地址
     */
    private String url;

    public ProjectConfig() {
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
