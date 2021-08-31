package com.crledu.auto.material.photon.biz.repository;

import com.crledu.auto.material.photon.biz.domain.AbsorbDomain;
import com.crledu.auto.material.photon.repository.dto.PhotonSelection;
import com.crledu.auto.material.photon.repository.dto.PhotonImport;

import java.util.List;

/**
 * @Author: Trevor
 * @Date: 2020/7/10 09:58
 * @Description:
 */
public interface PhotonRepository {

    void save(PhotonImport photonImport);

    void saveExecl(List<PhotonImport> list);

    List<PhotonImport> dbToExcel(PhotonSelection photonSelection);

    void saveData(AbsorbDomain absorbDomain);
}
