package com.crledu.auto.material.bigdata.biz.service;

import java.io.File;

/**
 ************************************************************
 * @Description: 深度学习数据仓库相关服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/18 16:59
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseBigdataRepositoryService {

    String saveData(Object data,Long importId);
    File downloadData(Long id);
    String getDataFile(String path);
    Integer deleteDataFile(Long importId);
    String countDataDileSize();
}
