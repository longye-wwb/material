package com.crledu.auto.material.photon.api.vo;

import com.crledu.auto.material.photon.repository.entity.Photon;

import java.util.List;

/**
 * @Author: Trevor
 * @Date: 2020/7/10 10:29
 * @Description:  光子详细信息vo
 */
public class PhotonInfoVo {

    private Long current;  //当前页码
    private Long size;     //每页展示条数
    private List<Photon> photonList;
    private Long total;

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public List<Photon> getPhotonList() {
        return photonList;
    }

    public void setPhotonList(List<Photon> photonList) {
        this.photonList = photonList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
