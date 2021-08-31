package com.crledu.auto.util.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crledu.auto.util.ObjectUtils;
import com.crledu.auto.web.vo.number.AbstractSelectNumberParamVo;

/**
 ************************************************************
 * @Description: 数值类型参数查询工具方法
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/7 9:35
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class NumberParamQueryWrapperUtils {

    public static void buildQueryWrapper(QueryWrapper queryWrapper, AbstractSelectNumberParamVo paramVo,String columnName){
        if(ObjectUtils.isNull(paramVo)){
            //如果参数等于空则不需要做任何操作
        }else{
            if(ObjectUtils.isNotNull(paramVo.getEq())){
                queryWrapper.eq(columnName,paramVo.getEq());
            }else{
                if(ObjectUtils.isNotNull(paramVo.getGt())){
                    queryWrapper.gt(columnName,paramVo.getGt());
                }else if(ObjectUtils.isNotNull(paramVo.getGte())){
                    queryWrapper.ge(columnName,paramVo.getGte());
                }
                if(ObjectUtils.isNotNull(paramVo.getLt())){
                    queryWrapper.lt(columnName,paramVo.getLt());
                }else if(ObjectUtils.isNotNull(paramVo.getLte())){
                    queryWrapper.le(columnName,paramVo.getLte());
                }
            }
        }
    }
}
