package com.crledu.auto.auth.token;

import java.util.UUID;

/**
 ************************************************************
 * @Description: 用户令牌信息
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/6/30 17:40
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class TokenInfo {

    /**
     * 凭据id
     */
    private Long userId;

    /**
     * 刷新token,预留
     */
    private String refrushToken;

    /**
     * token
     */
    private String token;

    /**
     * token有效时间
     */
    private Long expectTIme = 24L * 60L * 60L * 1000L;

    /**
     * 刷新token有效期
     */
    private Long expectRefrushTime = 7L * 24L * 60L * 60L * 1000L;

    public TokenInfo() {
    }

    public TokenInfo(Long userId) {
        this.userId = userId;
        this.token = UUID.randomUUID().toString().replaceAll("-","");
        this.refrushToken = UUID.randomUUID().toString().replaceAll("-","");
    }

    public TokenInfo(String refrushToken, String token) {
        this.refrushToken = refrushToken;
        this.token = token;
    }

    public void rebuildToken(){
        this.token = UUID.randomUUID().toString().replaceAll("-","");
    }

    public String getRefrushToken() {
        return refrushToken;
    }

    public String getToken() {
        return token;
    }

    public Long getExpectTIme() {
        return expectTIme;
    }

    public Long getExpectRefrushTime() {
        return expectRefrushTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setRefrushToken(String refrushToken) {
        this.refrushToken = refrushToken;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpectTIme(Long expectTIme) {
        this.expectTIme = expectTIme;
    }

    public void setExpectRefrushTime(Long expectRefrushTime) {
        this.expectRefrushTime = expectRefrushTime;
    }
}
