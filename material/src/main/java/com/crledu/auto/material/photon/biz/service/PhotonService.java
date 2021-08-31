package com.crledu.auto.material.photon.biz.service;

import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.photon.repository.dto.PhotonSelection;
import com.crledu.auto.material.photon.repository.dto.PhotonImport;
import com.crledu.auto.material.photon.repository.entity.Photon;
import com.crledu.auto.web.response.PageDate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: Trevor
 * @Date: 2020/7/10 09:48
 * @Description:
 */
public interface PhotonService {
    void addNew(PhotonImport photonImport);

    Photon getInfo(Long id);
    PageDate<Photon> getList(Integer current, Integer size);

    void addFromFile(MultipartFile file, MultipartFile process,Long user);
    void saveFromFile(MultipartFile file, MultipartFile process,Long user);

    List<PhotonImport> dbToExcel(PhotonSelection photonSelection);


}
