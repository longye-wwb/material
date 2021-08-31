package com.crledu.auto.material.photon.repository.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.crledu.auto.material.photon.repository.dto.PhotonSkyNewDto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
 * @Date: 2020/9/21
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class MyThread4 implements Runnable {

    private final CountDownLatch latch;

    private List<Double> firstList2;

    private List<List<Double>> fakeValueList;

    private List<List<Double>> realValueList;

    private String skyPath;

    private List<Long> idList;

    private Integer start;

    private Integer end;

    public List<Double> getFirstList2() {
        return firstList2;
    }

    public void setFirstList2(List<Double> firstList2) {
        this.firstList2 = firstList2;
    }

    public List<List<Double>> getFakeValueList() {
        return fakeValueList;
    }

    public void setFakeValueList(List<List<Double>> fakeValueList) {
        this.fakeValueList = fakeValueList;
    }

    public List<List<Double>> getRealValueList() {
        return realValueList;
    }

    public void setRealValueList(List<List<Double>> realValueList) {
        this.realValueList = realValueList;
    }

    public String getSkyPath() {
        return skyPath;
    }

    public void setSkyPath(String skyPath) {
        this.skyPath = skyPath;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public MyThread4(List<Double> firstList2, List<List<Double>> fakeValueList, List<List<Double>> realValueList, String skyPath, List<Long> idList, Integer start, Integer end,CountDownLatch latch) {
        this.firstList2 = firstList2;
        this.fakeValueList = fakeValueList;
        this.realValueList = realValueList;
        this.skyPath = skyPath;
        this.idList = idList;
        this.start = start;
        this.end = end;
        this.latch=latch;
    }

    public void fileCreate(List<Double> firstList2, List<List<Double>> fakeValueList, List<List<Double>> realValueList, String skyPath, List<Long> idList, Integer start,Integer end){
        for (int j = start; j < end; j++) {
            List<PhotonSkyNewDto> newDtos = new ArrayList<>();
            //每个频率的数据
            for (int i = 0; i < firstList2.size(); i++) {
                PhotonSkyNewDto newDto = new PhotonSkyNewDto();
                newDto.setFake(fakeValueList.get(j).get(i));
                newDto.setTruth(realValueList.get(j).get(i));
                newDto.setAmplitude(DoubleUtil.div(Math.sqrt(DoubleUtil.sum(Math.pow(fakeValueList.get(j).get(i), 2), Math.pow(realValueList.get(j).get(i), 2))), 1d, 9));
                Double c =DoubleUtil.sum(DoubleUtil.div(1d, Math.tan(DoubleUtil.div(fakeValueList.get(j).get(i), realValueList.get(j).get(i), 9)), 9),180d)%360d;
                if (c>0) {
                    newDto.setPhase(DoubleUtil.sub(c,180d));
                }else {
                    newDto.setPhase(DoubleUtil.sum(c,180d));
                }
                newDto.setWaveLength(DoubleUtil.div(300000d, firstList2.get(i), 4));
                newDto.setFrequency(firstList2.get(i));
                newDtos.add(newDto);
            }
            String fileRootPath = skyPath + File.separator + idList.get(j) / 1001;
            JSONArray.toJSONString(newDtos);
            String fileStr = JSONObject.toJSONString(newDtos);
            ;
            File file = new File(fileRootPath);
            if (!file.exists()) {//如果文件夹不存在
                file.mkdir();//创建文件夹
            }
            try {//异常处理
                //如果文件夹下没有就会创建该文件,一个结构参数对应一个文件。因此一次导入有一个文件夹，该文件夹下有多个文件
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileRootPath + File.separator + idList.get(j)));
                bw.write(fileStr);//在创建好的文件中写入文件内容
                bw.close();//一定要关闭文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void run() {
        fileCreate(firstList2,fakeValueList,realValueList,skyPath,idList,start,end);
        latch.countDown();
    }
}
