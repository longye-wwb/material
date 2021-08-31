package com.crledu.auto.material.system.data.service;

import com.crledu.auto.material.system.api.vo.DataVisitorCounterItemVo;

import java.util.List;

/**
 ************************************************************
 * @Description: 数据访问热度数据接口
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/2/20 14:54
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseVisitorCounterDataService {

    Float totalVisitor();
    List<DataVisitorCounterItemVo> listVisitor();
}
