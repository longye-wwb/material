package com.crledu.auto.material.user.biz.domain;

import java.util.Date;

/**
 ************************************************************
 * @Description: 用户的令牌
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/9 16:35
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class CredentialDomain {

    /**
     * 主键
     */
    private Long id;

    /**
     * 凭据的拥有用户
     */
    private Long user;

    /**
     *凭据类型
     */
    private Integer type;

    /**
     * 凭据的口令
     */
    private String account;

    /**
     * 凭据的密匙
     */
    private String password;

    /**
     * 口令有效期
     */
    private Date accountExpired;

    /**
     * 密匙有效期
     */
    private Date passwordExpired;

    /**
     * 凭据锁定
     */
    private Boolean locked;

    /**
     * 凭据是否有效
     */
    private Boolean enable;

    public CredentialDomain(Long id, Long user, Integer type, String account, String password, Date accountExpired, Date passwordExpired, Boolean locked, Boolean enable) {
        this.id = id;
        this.user = user;
        this.type = type;
        this.account = account;
        this.password = password;
        this.accountExpired = accountExpired;
        this.passwordExpired = passwordExpired;
        this.locked = locked;
        this.enable = enable;
    }

    private CredentialDomain(Long user, Integer type, String account, String password, Date accountExpired, Date passwordExpired, Boolean locked, Boolean enable){
        this.user = user;
        this.type = type;
        this.account = account;
        this.password = password;
        this.accountExpired = accountExpired;
        this.passwordExpired = passwordExpired;
        this.locked = locked;
        this.enable = enable;
    }

    public static CredentialDomain getInstance(Long user, Integer type, String account, String password, Date accountExpired, Date passwordExpired, Boolean locked, Boolean enable){
        return new CredentialDomain(user,type,account,password,accountExpired,passwordExpired,locked,enable);
    }

    public void changePassword(String account,String password){
        if(this.account.trim().equals(account)){
            this.password = password;
        }
    }

    public Long getId() {
        return id;
    }

    public Long getUser() {
        return user;
    }

    public Integer getType() {
        return type;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public Date getAccountExpired() {
        return accountExpired;
    }

    public Date getPasswordExpired() {
        return passwordExpired;
    }

    public Boolean getLocked() {
        return locked;
    }

    public Boolean getEnable() {
        return enable;
    }
}
