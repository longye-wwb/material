package com.crledu.auto.material.photon.repository.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

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
public class ExcelListener extends AnalysisEventListener {

    //自定义用于暂时存储data。
    //可以通过实例获取该值
    private List<Object> datas = new ArrayList<Object>();
    public void invoke(Object object, AnalysisContext context) {
        System.out.println("当前行："+context.getCurrentRowNum());
        System.out.println(object);
        datas.add(object);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
        doSomething(object);//根据自己业务做处理
    }
    private void doSomething(Object object) {
        //1、入库调用接口
    }
    public void doAfterAllAnalysed(AnalysisContext context) {
        // datas.clear();//解析结束销毁不用的资源
    }
    public List<Object> getDatas() {
        return datas;
    }
    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }
}
