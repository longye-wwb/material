package com.crledu.auto.material.photon.repository.util;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/9/18
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class MyThread3 implements Runnable {

    private final CountDownLatch latch;

    private List<List<Double>> realValueList =new ArrayList<>();

    private MultipartFile realSource;

    private boolean workDone=false;

    public List<List<Double>> getRealValueList() {
        return realValueList;
    }

    public void setRealValueList(List<List<Double>> realValueList) {
        this.realValueList = realValueList;
    }

    public MultipartFile getRealSource() {
        return realSource;
    }

    public void setRealSource(MultipartFile realSource) {
        this.realSource = realSource;
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public boolean isWorkDone() {
        return workDone;
    }

    public void setWorkDone(boolean workDone) {
        this.workDone = workDone;
    }

    public void toDoFile(MultipartFile realSource) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(realSource.getInputStream()));
            String line = null;

            String first = reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
            while ((line = reader.readLine()) != null) {
                String item[] = line.split("，");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                List<Double> doubles = new ArrayList<>();
                String last = item[item.length - 1];//这就是你要的数据了
                String[] lastArray = last.split(",");
                for (String s : lastArray) {
                    Double value = Double.parseDouble(s);

                    doubles.add(value);
                }
                realValueList.add(doubles);

            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public MyThread3(MultipartFile realFile,CountDownLatch latch){
        this.realSource=realFile;
        this.latch=latch;

    }

    @Override
    public void run() {

        toDoFile(realSource);
        workDone=true;
        latch.countDown();
    }
}
