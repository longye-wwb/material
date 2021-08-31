package com.crledu.auto.util.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crledu.auto.util.ObjectUtils;
import com.crledu.auto.web.vo.StringParamVo;

/**
 ************************************************************
 * @Description: 字符串类型参数查询
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/7 9:55
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class StringParamQueryWrapperUtils {

    public static void buildStringQueryWrapper(QueryWrapper queryWrapper, StringParamVo stringParamVo,String columnName){
        if(ObjectUtils.isNotNull(stringParamVo)){
            if(ObjectUtils.isNotNull(stringParamVo.getEq())){
                queryWrapper.eq(columnName,stringParamVo.getEq().trim());
            }else if(ObjectUtils.isNotNull(stringParamVo.getLike())){
                queryWrapper.like(columnName,stringParamVo.getLike());
            }
        }
    }
}
