package com.crledu.auto.web.view;

import java.util.HashMap;
import java.util.Map;

/**
 ************************************************************
 * @Description: 通用分页参数接参类型
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/17 9:13
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class PageMapParamVO extends PageParamVO {

    private Map<String,Object> params;

    public PageMapParamVO() {
        this.params = new HashMap<>();
    }

    public Object get(String key){
        return  params.get(key);
    }

    public void put(String key,Object value){
        params.put(key,value);
    }
}
