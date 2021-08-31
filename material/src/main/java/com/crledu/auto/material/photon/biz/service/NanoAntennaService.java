package com.crledu.auto.material.photon.biz.service;

import com.crledu.auto.material.photon.api.vo.*;
import com.crledu.auto.material.photon.repository.dto.PhotonSkyDto;
import com.crledu.auto.material.photon.repository.dto.PhotonSkySelection;
import com.crledu.auto.material.photon.repository.dto.PhotonSkySelectionNew;
import com.crledu.auto.material.photon.repository.entity.PhotonSky;

import com.crledu.auto.material.photon.repository.dto.PhotonSkySelectionMap;
import com.crledu.auto.web.response.PageDate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/9/4
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public interface NanoAntennaService {

    PhotonSky createPhotonSky(PhotonSkyDto photonSkyDto);

    List<Long> importStructrue(MultipartFile structure, Long id, String type);

    void importFakeAndReal(MultipartFile fake, MultipartFile real, List<Long> list, Long photonSkyId);

    PageDate<PhotonSkyVo> selectSkyList(PhotonSkySelection photonSkySelection);

    List<NanoAntennaCircleVo> selectCircleList(PhotonSkySelection photonSkySelection);

    List<NanoAntennaColumnVo> selectColumnList(PhotonSkySelection photonSkySelection);

    PageDate<PhotonSkyVoNew> selectSkyListNew(PhotonSkySelectionNew photonSkySelectionNew);

    List<PhotonSkyMapVo> selectSkyListMap(PhotonSkySelectionMap photonSkySelectionMap);

    void createPhotonSkyNew(PhotonSkyDto photonSkyDto, MultipartFile structure, MultipartFile fake, MultipartFile real);

    List<PhotonSkyMapVo> selectSkyListMapNew(SelectionMapNew selectionMapNew);

    void createNanoAntennaNew(NanoAntennaCreateVo createVo, Long id, MultipartFile structure, MultipartFile fake, MultipartFile real, MultipartFile process);
    void saveNanoAntennaNew(NanoAntennaCreateVo createVo, Long id, MultipartFile structure, MultipartFile fake, MultipartFile real, MultipartFile process);

    List<PhotonSkyMapVo> selectNanoAntenna(PhotonSkySelectionMap selectionMapNew);
}
