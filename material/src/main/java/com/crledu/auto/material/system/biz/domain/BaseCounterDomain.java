package com.crledu.auto.material.system.biz.domain;

import com.crledu.auto.util.ObjectUtils;

/**
 ************************************************************
 * @Description: 计数器
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/2/4 9:33
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class BaseCounterDomain {

    private Long id;
    private Float total;

    public BaseCounterDomain(Long id, Float total) {
        this.id = id;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public Float getTotal() {
        return total;
    }

    public void add(Float value){
        if(ObjectUtils.isNotNull(this.total)){
            this.total += value;
        }else{
            this.total = value;
        }
    }
}
