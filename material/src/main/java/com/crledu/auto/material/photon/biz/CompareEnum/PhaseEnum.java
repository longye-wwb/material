package com.crledu.auto.material.photon.biz.CompareEnum;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/9/29
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public enum PhaseEnum {
    more(1,"大于"),
    less(2,"小于");
    private Integer code;

    private String messege;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    PhaseEnum(Integer code,String messege) {
        this.code=code;
        this.messege=messege;
    }
}
