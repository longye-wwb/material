package com.crledu.auto.auth.exception;

import com.crledu.auto.web.exception.RestErrorException;
/**
 ************************************************************
 * @Description: 接口安全验证必要参数不存在。
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/3 9:39
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class NotSetRequiredHeaderParamException extends RestErrorException {

    private String name;

    public NotSetRequiredHeaderParamException(String name) {
        super("缺少必要的head参数："+name, "19001");
    }
}
