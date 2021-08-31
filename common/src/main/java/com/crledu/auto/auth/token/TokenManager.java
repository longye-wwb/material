package com.crledu.auto.auth.token;

/**
 ************************************************************
 * @Description: 系统token管理器
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/6/30 17:32
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface TokenManager {

    /**
     *****************************************************************************
     * @Description 根据用户主键创建令牌
     *****************************************************************************
     * @Param [userId]
     * @return com.crledu.auto.token.TokenInfo
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/6/30 17:42
     *****************************************************************************
     **/

    TokenInfo createToken(Long userId);

    /**
     *****************************************************************************
     * @Description 检查令牌是否已经过期或者失效
     *****************************************************************************
     * @Param [model]
     * @return boolean
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/6/30 17:43
     *****************************************************************************
     **/
    boolean checkToken(TokenInfo model);

    /**
     *****************************************************************************
     * @Description 根据传输的令牌串获取令牌信息
     *****************************************************************************
     * @Param [authentication]
     * @return com.crledu.auto.token.TokenInfo
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/6/30 17:44
     *****************************************************************************
     **/
    TokenInfo getToken(String authentication);

    /**
     *****************************************************************************
     * @Description 删除用户的令牌信息（退出登录）
     *****************************************************************************
     * @Param [userId]
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/6/30 17:47
     *****************************************************************************
     **/
    public void deleteToken(Long userId);
}