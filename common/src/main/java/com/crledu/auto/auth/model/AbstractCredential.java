package com.crledu.auto.auth.model;

import com.crledu.auto.auth.conf.CredentialType;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;

import java.io.Serializable;
import java.util.Date;

/**
 ************************************************************
 * @Description: 用户凭据顶层设计。
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/1 10:41
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public abstract class AbstractCredential implements Serializable {

    /**
     * 认证凭据的主键
     */
    private Long id;

    /**
     * 凭据对应的用户主键
     */
    private Long user;

    /**
     * 凭据的类型
     */
    private CredentialType type;

    /**
     * 认证凭据的唯一索引
     */
    private String account;

    /**
     * 认证凭据的校验令牌
     */
    private String password;

    /**
     * 索引的有效期
     */
    private Date accountExpired;

    /**
     * 凭据的密码有效期
     */
    private Date passwordExpired;

    /**
     * 凭据是否锁定
     */
    private Boolean locked;

    /**
     * 凭据是否可用
     */
    private Boolean enable;

    public AbstractCredential(Long user, CredentialType type, String account, String password) {
        this.user = user;
        this.type = type;
        this.account = account;
        this.password = password;
    }

    public AbstractCredential(Long id, Long user, CredentialType type, String account, String password) {
        this.id = id;
        this.user = user;
        this.type = type;
        this.account = account;
        this.password = password;
    }

    /**
     *****************************************************************************
     * @Description 锁定凭据
     *****************************************************************************
     * @Param []
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/1 11:09
     *****************************************************************************
     **/
    public void locked(){
        this.locked = true;
    }

    /**
     *****************************************************************************
     * @Description 解锁凭据
     *****************************************************************************
     * @Param []
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/1 11:10
     *****************************************************************************
     **/
    public void active(){
        this.locked = false;
    }

    /**
     *****************************************************************************
     * @Description 将凭据设为不可用
     *****************************************************************************
     * @Param []
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/1 11:11
     *****************************************************************************
     **/
    public void cannotEnable(){
        this.enable = false;
    }

    /**
     *****************************************************************************
     * @Description 将凭据设为可以使用
     *****************************************************************************
     * @Param []
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/1 11:11
     *****************************************************************************
     **/
    public void enabled(){
        this.enable = true;
    }

    /**
     *****************************************************************************
     * @Description 将账号的有效期设为，为空代表永久
     *****************************************************************************
     * @Param [lastTime]
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/1 11:12
     *****************************************************************************
     **/
    public void accountExpiredTo(Date lastTime){
        this.accountExpired = lastTime;
    }

    /**
     *****************************************************************************
     * @Description 将密码的有效期设为，为空代表永久
     *****************************************************************************
     * @Param [lastTime]
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/1 11:15
     *****************************************************************************
     **/
    public void passwordExpiredTo(Date lastTime){
        this.passwordExpired = lastTime;
    }

    /**
     *****************************************************************************
     * @Description 判断账号是否在有效期内
     *****************************************************************************
     * @Param []
     * @return java.lang.Boolean
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/1 11:16
     *****************************************************************************
     **/
    public Boolean isAccountNonExpired(){
        if(this.accountExpired == null){
            return true;
        }
        Date currentTime = new Date();
        if(this.accountExpired.after(currentTime)){
            return true;
        }else{
            return false;
        }
    }

    /**
     *****************************************************************************
     * @Description 凭据的密码是否在有效期内
     *****************************************************************************
     * @Param []
     * @return java.lang.Boolean
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/1 11:17
     *****************************************************************************
     **/
    public Boolean isCredentialsNonExpired(){
        if(this.passwordExpired == null){
            return true;
        }
        Date currentTime = new Date();
        if(this.passwordExpired.after(currentTime)){
            return true;
        }else{
            return false;
        }
    }

    /**
     *****************************************************************************
     * @Description 账号是否处于未锁定状态
     *****************************************************************************
     * @Param []
     * @return java.lang.Boolean
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/1 11:18
     *****************************************************************************
     **/
    public Boolean isAccountNonLocked(){
        return !locked;
    }

    public Long getId() {
        return id;
    }

    public Long getUser() {
        return user;
    }

    public CredentialType getType() {
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
