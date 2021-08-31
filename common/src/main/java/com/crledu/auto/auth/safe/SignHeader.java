package com.crledu.auto.auth.safe;

import com.crledu.auto.auth.conf.ClientApp;
import com.crledu.auto.util.http.HeaderUtils;
import com.crledu.auto.util.string.Md5Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 ************************************************************
 * @Description: 开放接口安全验证信息
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/2 17:32
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class SignHeader {

    /**
     * 调用方，甄别获得调用方的密码。
     */
    private String appkey;

    /**
     * 接口调用的时间，配合nonce,避免nonce在缓存中失效后，被重放。
     */
    private Long timestamp;

    /**
     * 随机加盐密匙,结合时间戳实现重放攻击防护
     */
    private String nonce;

    /**
     * 接口签名
     */
    private String sign;

    /**
     * 使用接口的用户。为了保证开放接口的安全，用户私密令牌不参与签名
     */
    private String token;

    /**
     * 由于安全级别，http协议参数体的问题，不便实现参数的签名。保留此字段。
     */
    private Map<String,String[]> params;

    public SignHeader(HttpServletRequest request) {
        appkey = HeaderUtils.getAppkey(request);
        timestamp = HeaderUtils.getTimeStemp(request);
        nonce = HeaderUtils.getNonce(request);
        sign = HeaderUtils.getSign(request);
        token = HeaderUtils.getToken(request);
        params = request.getParameterMap();
    }

    private String rebuildSign(){
        //由于没有参数的干扰，那么拼接顺序就为：nonce、signkey、timestamp、token
        String preString = paramsStr();
        String rsign = Md5Utils.stringToMD5(preString);
        return rsign;
    }

    private String paramsStr(){
        StringBuilder sb = new StringBuilder();
        sb.append(nonce);
        sb.append(ClientApp.getSignkeyBYAppkey(appkey));
        sb.append(timestamp);
        if(token != null&&!token.isEmpty()){
            sb.append(token);
        }
        return sb.toString();
    }

    public Boolean signRight(){
        if(sign.trim().equals(rebuildSign().trim())){
            return true;
        }else{
            return false;
        }
    }

    public String getToken() {
        return token;
    }
}
