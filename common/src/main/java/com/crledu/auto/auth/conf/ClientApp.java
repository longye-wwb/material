package com.crledu.auto.auth.conf;

/**
 ************************************************************
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/7/3 9:38
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public enum  ClientApp {
    PCHOME("home","pchome"),APPHOME("app","apphome");


    private String app_key;
    private String sign_key;

    ClientApp(String app_key, String sign_key) {
        this.app_key = app_key;
        this.sign_key = sign_key;
    }

    public static String getSignkeyBYAppkey(String appkey){
        ClientApp[] clientApps = ClientApp.values();
        for(ClientApp clientApp:clientApps){
            if(clientApp.app_key.trim().equals(appkey.trim())){
                return clientApp.sign_key;
            }
        }
        return PCHOME.sign_key;
    }
}
