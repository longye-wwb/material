package com.crledu.auto.material.photon.repository.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.crledu.auto.material.photon.biz.repository.PhotonRepository;
import com.crledu.auto.material.photon.biz.repository.PhotonRepositoryImpl;
import com.crledu.auto.material.photon.repository.dto.PhotonImport;

import java.util.ArrayList;
import java.util.List;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/8/4
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class PhotonListener extends AnalysisEventListener<PhotonImport> {

    List<PhotonImport> list = new ArrayList();
    public PhotonListener() {
        photonRepository=new PhotonRepositoryImpl();
    }

    private static final int BATCH_COUNT = 3000;
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private PhotonRepository photonRepository;

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param photonRepository
     */
    public PhotonListener(PhotonRepository photonRepository) {
        this.photonRepository = photonRepository;
    }
    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data
     *            one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     * 该方法不会读取表头
     * 一行一行读取excel内容
     */
    @Override
    public void invoke(PhotonImport data, AnalysisContext context) {
       String s=JSON.toJSONString(data);//使用需要导入json依赖
        System.out.println(s);
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }
    /**
     * 所有数据解析完成了 都会来调用
     *读取完毕后操作
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
    }
    /**
     * 加上存储数据库
     */
    private void saveData() {
        System.out.println("{}条数据，开始存储数据库！"+list.size());
        photonRepository.saveExecl(list);

    }

}
