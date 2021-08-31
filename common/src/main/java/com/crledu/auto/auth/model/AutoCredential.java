package com.crledu.auto.auth.model;

import com.crledu.auto.auth.conf.CredentialType;
/**
 ************************************************************
 * @Description: 系统默认的登录令牌
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/2 17:26
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class AutoCredential extends AbstractCredential {

    public AutoCredential(Long user, CredentialType type, String account, String password) {
        super(user, type, account, password);
    }

    public AutoCredential(Long id, Long user, CredentialType type, String account, String password) {
        super(id, user, type, account, password);
    }
}
