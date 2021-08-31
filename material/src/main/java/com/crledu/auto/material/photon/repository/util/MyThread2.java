package com.crledu.auto.material.photon.repository.util;

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
public class MyThread2 implements Runnable{

    private final CountDownLatch latch;

    private List<String> firstList=new ArrayList<>();

    private List<List<Double>> valueList=new ArrayList<>();

    private MultipartFile  structure;

    private boolean workDone=false;

    public boolean isWorkDone() {
        return workDone;
    }

    public void setWorkDone(boolean workDone) {
        this.workDone = workDone;
    }

    public List<String> getFirstList() {
        return firstList;
    }

    public void setFirstList(List<String> firstList) {
        this.firstList = firstList;
    }

    public List<List<Double>> getValueList() {
        return valueList;
    }

    public void setValueList(List<List<Double>> valueList) {
        this.valueList = valueList;
    }

    public MultipartFile getStructure() {
        return structure;
    }

    public void setStructure(MultipartFile structure) {
        this.structure = structure;
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    //1.将结构参数文件读取出
  public void toDoFile(MultipartFile getStructure) {
      BufferedReader reader = null;//换成你的文件名
      reader = null;
      try {
          reader = new BufferedReader(new InputStreamReader(structure.getInputStream()));

          String first = reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
          String line = null;

          String[] firstArray = first.split(",");
          for (String s : firstArray) {
              firstList.add(s);
          }
          while ((line = reader.readLine()) != null) {
              String item[] = line.split("，");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
              List<Double> doubles = new ArrayList<>();
              String last = item[item.length - 1];//这就是你要的数据了
              String[] lastArray = last.split(",");
              for (String s : lastArray) {
                  Double value = Double.parseDouble(s);

                  doubles.add(value);
              }
              valueList.add(doubles);

          }
      } catch (
              IOException e) {
          e.printStackTrace();
      }
  }


  public MyThread2(MultipartFile  structureSource,CountDownLatch latch){
        this.structure=structureSource;
        this.latch=latch;
  }

    @Override
    public void run() {
        toDoFile(structure);
        workDone=true;
        latch.countDown();

    }
}
