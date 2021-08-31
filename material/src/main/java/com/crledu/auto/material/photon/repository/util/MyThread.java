package com.crledu.auto.material.photon.repository.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
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
public class MyThread implements Runnable {

    private final CountDownLatch latch;

    private List<List<Double>> fakeValueList =new ArrayList<>();

    private List<Double> firstList2=new ArrayList<>();

    private MultipartFile fakeSource;

    private boolean workDone=false;

    public List<List<Double>> getFakeValueList() {
        return fakeValueList;
    }

    public void setFakeValueList(List<List<Double>> fakeValueList) {
        this.fakeValueList = fakeValueList;
    }



    public List<Double> getFirstList2() {
        return firstList2;
    }

    public void setFirstList2(List<Double> firstList2) {
        this.firstList2 = firstList2;
    }

    public MultipartFile getFakeSource() {
        return fakeSource;
    }

    public void setFakeSource(MultipartFile fakeSource) {
        this.fakeSource = fakeSource;
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

    public void toDOFile(MultipartFile fake){
        BufferedReader reader = null;//换成你的文件名
        try {
            reader = new BufferedReader(new InputStreamReader(fake.getInputStream()));

            String first=reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
            String line = null;

            String[] firstArray = first.split(",");
            for (String s:firstArray){
                Double value=Double.parseDouble(s);
                firstList2.add(value);
            }
            while ((line = reader.readLine()) != null) {
                String item[] = line.split("，");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                List<Double> doubles = new ArrayList<>();
                String last = item[item.length - 1];//这就是你要的数据了
                String[] lastArray = last.split(",");
                for (String s:lastArray){
                    Double value=Double.parseDouble(s);

                    doubles.add(value);
                }
                fakeValueList.add(doubles);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public MyThread(MultipartFile fakeFile,CountDownLatch latch){
        this.fakeSource=fakeFile;
        this.latch = latch;

    }

    @Override
    public void run() {
        toDOFile(fakeSource);
        workDone=true;
        latch.countDown();
    }
}
