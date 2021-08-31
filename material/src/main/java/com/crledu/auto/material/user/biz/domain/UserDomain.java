package com.crledu.auto.material.user.biz.domain;

import com.crledu.auto.auth.conf.CredentialType;
import com.crledu.auto.material.user.biz.dto.UserUpdateDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 ************************************************************
 * @Description: 材料数据库用户管理
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/9 16:28
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class UserDomain {

    /**
     * 用户主键
     */
    private Long id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户头像
     */
    private String profile;

    /**
     * 出生日期
     */
    private Date borthday;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户电话
     */
    private String mobail;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 用户令牌
     */
    private List<CredentialDomain> credentialDomains;

    public UserDomain(Long id, String name, String profile, Date borthday, String email, String mobail, Integer status, List<CredentialDomain> credentialDomains) {
        this.id = id;
        this.name = name;
        this.profile = profile;
        this.borthday = borthday;
        this.email = email;
        this.mobail = mobail;
        this.status = status;
        this.credentialDomains = credentialDomains;
    }

    private UserDomain(String name, String profile, Date borthday, String email, String mobail){
        this.name = name;
        this.profile = profile;
        this.borthday = borthday;
        this.email = email;
        this.mobail = mobail;
        this.status = 1;
        this.credentialDomains = new ArrayList<>();
    }

    public static UserDomain getInstance(String name, String profile, Date borthday, String email, String mobail){
        return new UserDomain(name, profile, borthday, email, mobail);
    }

    /**
     *****************************************************************************
     * @Description 为用户添加账号密码登录认证凭据
     *****************************************************************************
     * @Param [account, password]
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/11/10 9:44
     *****************************************************************************
     **/
    public void addAccountLogin(String account,String password){
        CredentialDomain credentialDomain = CredentialDomain.getInstance(this.id, CredentialType.ACCOUNT.getCode(),account,password,null,null,false,true);
        if(this.credentialDomains == null){
            this.credentialDomains = new ArrayList<>();
        }
        this.credentialDomains.add(credentialDomain);
    }

    /**
     *****************************************************************************
     * @Description 为用户添加CAS认证凭据
     *****************************************************************************
     * @Param [sid, password]
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/11/10 9:45
     *****************************************************************************
     **/
    public void addCasLogin(String sid,String password){
        CredentialDomain credentialDomain = CredentialDomain.getInstance(this.id, CredentialType.CAS.getCode(),sid,password,null,null,false,true);
        if(this.credentialDomains == null){
            this.credentialDomains = new ArrayList<>();
        }
        this.credentialDomains.add(credentialDomain);
    }

    /**
     *****************************************************************************
     * @Description 修改用户头像
     *****************************************************************************
     * @Param [profile]
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/11/10 9:47
     *****************************************************************************
     **/
    public void editeProfile(String profile){
        this.profile = profile;
    }

    /**
     *****************************************************************************
     * @Description 修改用户基础信息
     *****************************************************************************
     * @Param [updateDto]
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/11/10 9:57
     *****************************************************************************
     **/
    public void editeUserInfo(UserUpdateDto updateDto){
        this.name = updateDto.getName();
        this.email = updateDto.getEmail();
        this.borthday = updateDto.getBorthday();
        this.mobail = updateDto.getMobel();
    }

    public void changeUserPassword(String password,String account){
        if(this.credentialDomains != null){
            for(CredentialDomain credentialDomain:this.credentialDomains){
                if(credentialDomain.getAccount().trim().equals(account.trim())){
                    credentialDomain.changePassword(account,password);
                    return;
                }
            }
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfile() {
        return profile;
    }

    public Date getBorthday() {
        return borthday;
    }

    public String getEmail() {
        return email;
    }

    public String getMobail() {
        return mobail;
    }

    public Integer getStatus() {
        return status;
    }

    public List<CredentialDomain> getCredentialDomains() {
        return credentialDomains;
    }
}
