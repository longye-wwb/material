package com.crledu.auto.material.photon.repository.util;

import com.crledu.auto.material.photon.api.vo.PhotonSkyMapVo;

import java.util.List;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/9/17
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class QuikSortUtil {

    public static void quickSort(List<PhotonSkyMapVo> list, int l, int r){
        if(l>=r)
            return;

        int i = l; int j = r; Double key = list.get(l).getFrequency();//选择第一个数为key
        PhotonSkyMapVo photonSkyMapVo=list.get(l);

        while(i<j){

            while(i<j && list.get(j).getFrequency().compareTo(key)>=0)//从右向左找第一个小于key的值
                j--;
            if(i<j){
                //

                list.set(i,list.get(j));
                i++;
            }

            while(i<j && list.get(i).getFrequency().compareTo(key)<0)//从左向右找第一个大于key的值
                i++;

            if(i<j){
                list.set(j,list.get(i));
                j--;
            }
        }
        //i == j
        list.set(i,photonSkyMapVo);
        quickSort(list, l, i-1);//递归调用
        quickSort(list, i+1, r);//递归调用
    }
}
